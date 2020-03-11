package com.sxlg.goblet.model;

import java.io.Serializable;
import java.util.List;

public class GobletRecord implements Serializable {

    private List<Object> data;
    private long es;
    private long ts;
    private String id;
    private String isDdl;
    private MysqlType mysqlType;
    private List<Object> old;
    private String pkNames;
    private String sql;
    private SqlType sqlType;
    private String table;
    private String type;

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public long getEs() {
        return es;
    }

    public void setEs(long es) {
        this.es = es;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsDdl() {
        return isDdl;
    }

    public void setIsDdl(String isDdl) {
        this.isDdl = isDdl;
    }

    public MysqlType getMysqlType() {
        return mysqlType;
    }

    public void setMysqlType(MysqlType mysqlType) {
        this.mysqlType = mysqlType;
    }

    public List<?> getOld() {
        return old;
    }

    public void setOld(List<Object> old) {
        this.old = old;
    }

    public String getPkNames() {
        return pkNames;
    }

    public void setPkNames(String pkNames) {
        this.pkNames = pkNames;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public SqlType getSqlType() {
        return sqlType;
    }

    public void setSqlType(SqlType sqlType) {
        this.sqlType = sqlType;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "JoyQueueMessage{" +
                "data=" + data +
                ", es=" + es +
                ", ts=" + ts +
                ", id='" + id + '\'' +
                ", isDdl='" + isDdl + '\'' +
                ", mysqlType=" + mysqlType +
                ", old=" + old +
                ", pkNames='" + pkNames + '\'' +
                ", sql='" + sql + '\'' +
                ", sqlType=" + sqlType +
                ", table='" + table + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
