package com.sxlg.goblet.store;

import com.alibaba.fastjson.JSONObject;
import com.sxlg.goblet.data.SouterRecord;

import java.util.List;

public interface DataBaseStore {
    void  write(List<SouterRecord> records);
    String  sqlAssemble(String sqlType, String tableName, JSONObject newData, JSONObject oldData, String pk);
    String sqlAssemble();
}
