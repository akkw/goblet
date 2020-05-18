package com.sxlg.goblet.data;

import com.alibaba.fastjson.JSONObject;

public class SouterRecord {
    private JSONObject newData;
    private int database;
    private int table;
    private String type;
    private String tablePk;
    private JSONObject oldDate;

    public String getTablePk() {
        return tablePk;
    }

    public void setTablePk(String tablePk) {
        this.tablePk = tablePk;
    }

    public SouterRecord(JSONObject newData, JSONObject oldDate, int database, int table, String type, String pk) {
        this.newData = newData;
        this.oldDate = oldDate;
        this.database = database;
        this.table = table;
        this.type = type;
        this.tablePk = pk;
    }

    public JSONObject getOldDate() {
        return oldDate;
    }

    public void setOldDate(JSONObject oldDate) {
        this.oldDate = oldDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JSONObject getNewData() {
        return newData;
    }

    public void setNewData(JSONObject newData) {
        this.newData = newData;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }
}
