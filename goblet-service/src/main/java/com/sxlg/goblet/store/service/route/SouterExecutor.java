package com.sxlg.goblet.store.service.route;

import com.alibaba.fastjson.JSONObject;
import com.sxlg.goblet.service.mysql.MySQLStore;
import com.sxlg.goblet.store.DataBaseStore;
import com.sxlg.goblet.data.SouterRecord;
import com.sxlg.goblet.data.hash.Hash;
import com.sxlg.goblet.data.model.GobletRecord;
import com.sxlg.goblet.data.model.SqlType;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class SouterExecutor implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(SouterExecutor.class);
    private BlockingQueue<ByteBuffer> queueData = null;
    private RouterConfig routerConfig = null;
    private DataBaseStore dataBaseStore;
    private int slotNumber;
    private int databaseNumber;
    private String routerKey;
    private String tablePk;

    public SouterExecutor(RouterConfig router) {
        this.routerConfig = router;
        this.queueData = routerConfig.getDataQueue();
        this.dataBaseStore = new MySQLStore(routerConfig.getTopology());
        this.slotNumber = routerConfig.getSlotNumber();
        this.tablePk = routerConfig.getTableKp();
        this.routerKey = routerConfig.getRouterKey();
        this.databaseNumber = routerConfig.getInstanceNumber();
    }

    public void run() {
        ByteBuffer take = null;
        while(true) {
            try {
                    GobletRecord message = messageDeserialize(queueData.take());
                List<SouterRecord> records = buildSouterRecord(message);
                dataBaseStore.write(records);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private List<SouterRecord> buildSouterRecord(GobletRecord message) {
        List<SouterRecord> records = new ArrayList<>();
        typeHandle(message);
        if (message.getType().equalsIgnoreCase("INSERT") ||
                message.getType().equalsIgnoreCase("DELETE")) {
            message.getData().stream().forEach( m -> {

                String key = ((JSONObject) m).getString(routerKey);

                if (key != null && key.trim() != ""){
                    int tableHash = Hash.DEKHash(key, slotNumber);
                    int databaseHash = Hash.APHash(key, databaseNumber);

                    records.add(new SouterRecord((JSONObject) m,null, databaseHash ,tableHash, message.getType(), tablePk));
                }
            });
        } else if (message.getType().equalsIgnoreCase("UPDATE")){
            int dataSize = message.getData().size();
            int oldSize = message.getOld().size();

            if (dataSize == oldSize) {
                for (int index = 0; index < dataSize; index++){
                    JSONObject oldData = (JSONObject) message.getOld().get(index);
                    JSONObject newData = (JSONObject) message.getData().get(index);
                    int tableHash = 0;
                    int databaseHash = 0;
                    if (oldData.containsKey(routerKey)){
                        String key = oldData.getString(routerKey);
                        tableHash = Hash.DEKHash(key, slotNumber);
                        databaseHash = Hash.APHash(key, databaseNumber);
                    } else {
                        String key = newData.getString(routerKey);
                        tableHash = Hash.DEKHash(key, slotNumber);
                        databaseHash = Hash.APHash(key, databaseNumber);
                    }
                    records.add(new SouterRecord(newData, oldData, databaseHash ,tableHash, message.getType(), tablePk));

                }
            }
        }
        if (tablePk == null || slotNumber < 0 || databaseNumber < 0) {
            logger.warn("tablePk is {}, slotNumber is {} databaseNumber {}", tablePk, slotNumber, databaseNumber);
        }
        return records;
    }

    private void typeHandle(GobletRecord message)  {
        SqlType sqlType = message.getSqlType();
        Field[] fields = sqlType.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try{
                String name = fields[i].getName();
                fields[i].setAccessible(true);
                Object type = fields[i].get(message.getSqlType());
                typeHandle(type, name, message);
            } catch (IllegalAccessException e){
                logger.error("type handling failure: " + e);
            }

        }


    }
    private void typeHandle(Object type, String name, GobletRecord message){
        if (message.getType().equalsIgnoreCase("UPDATE")) {
            int size = message.getData().size();
            int oldSize = message.getOld().size();
            if (size != oldSize) {
                logger.error("the amount of data is not equal");
            }

        }

        if (type.equals(JDBCType.VARCHAR.getVendorTypeNumber().toString())) {
            List<Object> dataList = message.getData();
            List<Object> oldList = message.getOld();
            if (oldList != null) {
                Iterator<Object> dataIt = dataList.iterator();
                Iterator<Object> oldIt = oldList.iterator();
                while (dataIt.hasNext()) {
                    JSONObject data = (JSONObject) dataIt.next();
                    JSONObject old = (JSONObject) oldIt.next();
                    String dataRresult = "'" + data.getString(name) + "'";
                    String oldResult = "'" + old.getString(name) + "'";
                    data.put(name, dataRresult);
                    old.put(name, oldResult);
                }

            } else {
                Iterator<Object> dataIt = dataList.iterator();
                while (dataIt.hasNext()) {
                    JSONObject dataResult = (JSONObject) dataIt.next();
                    String result = "'" + dataResult.getString(name) + "'";
                    dataResult.put(name,result);
                }
            }
        }

    }

    public GobletRecord messageDeserialize(ByteBuffer buffer) throws InterruptedException {

        GobletRecord deserialize = (GobletRecord) SerializationUtils.deserialize(buffer.array());

        return deserialize;
    }








}
