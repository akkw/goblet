package com.sxlg.goblet.api.Impl;


import com.sxlg.goblet.acceptor.Pull;
import com.sxlg.goblet.deserialization.JoyMessageDeserialization;
import io.openmessaging.consumer.MessageListener;
import io.openmessaging.message.Message;
import org.springframework.stereotype.Service;



@Service("queuePull")
public class JoyQueuePull implements Pull {


    @Override
    public void fetch(Message message, MessageListener.Context context) {
        if (message != null) {
           String decodeMessage = JoyMessageDeserialization.doDecoding(message.getData(),
                   message.getData().length);


        }
    }
}
