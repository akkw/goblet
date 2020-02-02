package com.sxlg.goblet.source;

import com.sxlg.gbolet.network.worker.DefultSendWorker;
import com.sxlg.goblet.acceptor.Pull;
import io.openmessaging.consumer.MessageListener;
import io.openmessaging.message.Message;
import io.openmessaging.spring.boot.annotation.OMSMessageListener;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Component
@OMSMessageListener(queueName = "example")
public class GobletDataSource implements MessageListener{
    @Autowired
    Pull queuePull;

    private static BlockingQueue<ByteBuffer> dataWarehouse = new ArrayBlockingQueue<ByteBuffer>(1024, true);

    public GobletDataSource() throws IOException {
        DefultSendWorker worker = new DefultSendWorker(dataWarehouse);
        worker.start();
    }

    public void onReceived(Message message, MessageListener.Context context) {
        byte[] bytes = SerializationUtils.serialize(queuePull.fetch(message, context));
        dataWarehouse.add(ByteBuffer.wrap(bytes));
    }


}
