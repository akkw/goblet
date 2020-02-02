package com.sxlg.goblet.api.Impl;


import com.sxlg.goblet.acceptor.Pull;
import com.sxlg.goblet.deserialization.JSONTransform;
import com.sxlg.goblet.deserialization.JoyMessageDeserialization;
import com.sxlg.goblet.model.JoyQueueMessage;
import io.openmessaging.consumer.MessageListener;
import io.openmessaging.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service("queuePull")
public class JoyQueuePull implements Pull {
    Logger logger = LoggerFactory.getLogger(JoyQueuePull.class);


    public JoyQueueMessage fetch(Message message, MessageListener.Context context) {
        JoyQueueMessage data = null;
        if (message != null) {
           String decodeMessage = JoyMessageDeserialization.doDecoding(message.getData(),
                   message.getData().length);
            data = JSONTransform.StringToObject(decodeMessage, JoyQueueMessage.class);
            if (context != null) {
                context.ack();
            }
        }
        return data;
    }
}
