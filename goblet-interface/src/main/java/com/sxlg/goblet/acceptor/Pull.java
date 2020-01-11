package com.sxlg.goblet.acceptor;

import io.openmessaging.consumer.MessageListener;
import io.openmessaging.message.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface Pull {
    void fetch(Message message, MessageListener.Context context);
}
