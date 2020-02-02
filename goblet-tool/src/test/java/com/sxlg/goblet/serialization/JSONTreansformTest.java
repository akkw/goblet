package com.sxlg.goblet.serialization;

import com.sxlg.goblet.deserialization.JSONTransform;
import com.sxlg.goblet.model.JoyQueueMessage;
import org.junit.Test;

public class JSONTreansformTest {
    @Test
    public void JSONTest(){

        String param = "{\"data\":[{\"id\":\"1\",\"a\":\"1\",\"b\":\"1\",\"c\":\"1\"}],\"database\":\"test\",\"es\":1580449983000,\"id\":26,\"isDdl\":false,\"mysqlType\":{\"id\":\"int\",\"a\":\"int\",\"b\":\"int\",\"c\":\"int\"},\"old\":null,\"pkNames\":null,\"sql\":\"\",\"sqlType\":{\"id\":4,\"a\":4,\"b\":4,\"c\":4},\"table\":\"test1\",\"ts\":1580449983607,\"type\":\"INSERT\"}\n";
        JoyQueueMessage message = JSONTransform.StringToObject(param, JoyQueueMessage.class);

    }
}
