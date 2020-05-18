package com.sxlg.goblet.api.Impl;


import com.sxlg.goblet.store.acceptor.Pull;
import com.sxlg.goblet.store.deserialization.JSONTransform;
import com.sxlg.goblet.store.deserialization.JoyMessageDeserialization;
import com.sxlg.goblet.data.model.GobletRecord;
import io.openmessaging.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service("queuePull")
public class JoyQueuePull implements Pull {
    Logger logger = LoggerFactory.getLogger(JoyQueuePull.class);


    public GobletRecord pares(Message message) {
        GobletRecord data = null;
        if (message != null) {
           String decodeMessage = JoyMessageDeserialization.doDecoding(message.getData(),
                   message.getData().length);
            data = JSONTransform.StringToObject(decodeMessage, GobletRecord.class);
        }
        return data;
    }

}
