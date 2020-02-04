package com.sxlg.goblet.acceptor;

import com.sxlg.goblet.model.JoyQueueMessage;
import io.openmessaging.consumer.MessageListener;
import io.openmessaging.message.Message;


public interface Pull {
    JoyQueueMessage fetch(Message message);
}
