package com.sxlg.goblet.joyqueue.consumer;

import com.sxlg.goblet.acceptor.Pull;
import io.openmessaging.consumer.MessageListener;
import io.openmessaging.message.Message;
import io.openmessaging.spring.boot.annotation.OMSMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@OMSMessageListener(queueName = "example")
public class JoyQueueConsumer implements MessageListener{
    @Autowired
    Pull queuePull;

    @Override
    public void onReceived(Message message, MessageListener.Context context) {
        queuePull.fetch(message,context);
    }
}
