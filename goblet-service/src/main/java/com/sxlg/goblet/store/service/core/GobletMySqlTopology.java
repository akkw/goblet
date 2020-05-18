package com.sxlg.goblet.store.service.core;

import com.alibaba.druid.pool.DruidDataSource;
import com.sxlg.goblet.store.service.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class GobletMySqlTopology {
    private static final Logger logger = LoggerFactory.getLogger(GobletMySqlTopology.class);
    //表记录
    private ConcurrentMap<Integer, String> tableMap = new ConcurrentHashMap<Integer, String>();
    //数据库实例
    private MySqlInstancePool instanceMap = null;
    private int tableNumber = 0;
    private int databaseNumber = 0;
    private String routerKey;
    public String getTableName(int index) {
        return tableMap.get(index);
    }

    private GobletMySqlTopology(Configuration configuration){
        int slotSize = Integer.parseInt(configuration.getTableNumber());
        if (slotSize <= 0) {
            logger.warn("the number of tables is less than {}", slotSize);
        }
        for (int i = 0; i < slotSize; i++) {
            tableMap.put(i, configuration.getTableName() + "_" + i);
        }
        instanceMap = new MySqlInstancePool(Integer.parseInt(configuration.getInstanceNumber()));
        instanceMap.build();
    }

    public static GobletMySqlTopology build(Configuration configuration) {

        return new GobletMySqlTopology(configuration);
    }

    public DruidDataSource getInstance(int id) {
        return instanceMap.getInstance(id);
    }

}
