package com.sxlg.goblet.service.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.sxlg.goblet.store.DataBaseStore;
import com.sxlg.goblet.data.SQLKeyword;
import com.sxlg.goblet.data.SouterRecord;
import com.sxlg.goblet.store.service.core.GobletMySqlTopology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MySQLStore implements DataBaseStore {
    private static final Logger logger = LoggerFactory.getLogger(MySQLStore.class);
    private final static String SQL_TYPE_INSERT = "INSERT";
    private final static String SQL_TYPE_DELETE = "DELETE";
    private final static String SQL_TYPE_UPDATE = "UPDATE";

    private GobletMySqlTopology topology;

    public MySQLStore(GobletMySqlTopology topology) {
        this.topology = topology;
    }


    public String sqlAssemble(String sqlType, String tableName, JSONObject newData, JSONObject oldData, String pk) {
        StringBuilder sql = new StringBuilder();
        if (sqlType.equalsIgnoreCase(SQL_TYPE_INSERT)) {

            sql.append(SQLKeyword.INSERT_INTO.getSqlKeyword()).append(tableName).
                    append(SQLKeyword.LEFT_BRACKET.getSqlKeyword());
            Iterator<Map.Entry<String, Object>> it = newData.entrySet().iterator();
            StringBuilder value = new StringBuilder(SQLKeyword.VALUES.getSqlKeyword()).
                    append(SQLKeyword.LEFT_BRACKET.getSqlKeyword());

            while (it.hasNext()) {

                Map.Entry<String, Object> next = it.next();
                sql.append(next.getKey());
                value.append(next.getValue());

                if (it.hasNext()) {
                    sql.append(SQLKeyword.COMMA.getSqlKeyword());
                    value.append(SQLKeyword.COMMA.getSqlKeyword());
                } else {
                    sql.append(SQLKeyword.RIGHT_BRACKET.getSqlKeyword());
                    value.append(SQLKeyword.RIGHT_BRACKET.getSqlKeyword());
                    sql.append(value);
                }
            }

        } else if (sqlType.equalsIgnoreCase(SQL_TYPE_UPDATE)) {

            sql.append(SQLKeyword.UPDATE.getSqlKeyword()).append(tableName).append(SQLKeyword.SET.getSqlKeyword());
            Iterator<Map.Entry<String, Object>> it = newData.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                if (it.hasNext()) {
                    sql.append(next.getKey()).append(SQLKeyword.EQUAL.getSqlKeyword()).append(next.getValue())
                            .append(SQLKeyword.COMMA.getSqlKeyword());
                } else {
                    sql.append(next.getKey()).append(SQLKeyword.EQUAL.getSqlKeyword()).append(next.getValue());
                }
            }
            sql.append(SQLKeyword.WHERE.getSqlKeyword());

            if (oldData.containsKey(pk)) {
                String oldPk = oldData.getString(pk);
                sql.append(pk).append(SQLKeyword.EQUAL).append(oldPk);

            } else {
                String newPk = newData.getString(pk);
                sql.append(pk).append(SQLKeyword.EQUAL.getSqlKeyword()).append(newPk);
            }
        } else if (sqlType.equalsIgnoreCase(SQL_TYPE_DELETE)) {
            sql.append(SQLKeyword.DELETE.getSqlKeyword()).append(SQLKeyword.FROM.getSqlKeyword()).
                    append(tableName).append(SQLKeyword.WHERE.getSqlKeyword()).append(pk).append(SQLKeyword.EQUAL.getSqlKeyword()).
                    append(newData.getString(pk));
        }
        return sql.toString();
    }

    @Override
    public String sqlAssemble() {
        return null;
    }

    public void write(List<SouterRecord> records) {
        if (records != null && !records.isEmpty()) {
            records.stream().forEach(r -> {

                String tableName = topology.getTableName(r.getTable());
                String sql = sqlAssemble(r.getType(), tableName, r.getNewData(), r.getOldDate(), r.getTablePk());

                try {
                    DruidDataSource instance = topology.getInstance(r.getDatabase());
                    instance.getConnection().prepareStatement(sql).execute();
                } catch (MySQLSyntaxErrorException e) {
                    logger.warn("sql syntax error ", e);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

