package com.sxlg.goblet.source;

import com.sxlg.gbolet.network.worker.DefultSendWorker;
import com.sxlg.goblet.store.acceptor.Pull;
import com.sxlg.goblet.store.conversion.Constant;
import com.sxlg.goblet.store.conversion.NumberConversion;
import com.sxlg.goblet.data.SourceMessage;
import com.sxlg.goblet.data.model.GobletRecord;
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
@OMSMessageListener(queueName = "goblet")
public class GobletDataSource implements MessageListener{
    @Autowired
    Pull queuePull;
    private int len = 0;
    private  BlockingQueue<SourceMessage> dataWarehouse = new ArrayBlockingQueue<SourceMessage>(1024, true);
    public GobletDataSource() throws IOException {
        DefultSendWorker worker = new DefultSendWorker(dataWarehouse);
        worker.start();
    }

    public void onReceived(Message message, MessageListener.Context context) {
        GobletRecord fetch = queuePull.pares(message);
        byte[] bytes = SerializationUtils.serialize(fetch);
        byte[] packetLengthByte = NumberConversion.intToByte4(bytes.length);
        ByteBuffer byteBuffer = ByteBuffer.allocate(Constant.PACKET_HEAD_SIZE + bytes.length);
        byteBuffer.put(packetLengthByte);
        byteBuffer.put(ByteBuffer.wrap(bytes));
        byteBuffer.flip();

        dataWarehouse.add(new SourceMessage(byteBuffer, context));
    }


}
