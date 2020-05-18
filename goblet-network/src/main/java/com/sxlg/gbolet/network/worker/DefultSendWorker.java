package com.sxlg.gbolet.network.worker;

import com.sxlg.goblet.network.channel.ServerSocketChannalTransport;
import com.sxlg.goblet.data.SourceMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefultSendWorker extends AbstractSendWorker{
    private static final Logger logger = LoggerFactory.getLogger(DefultSendWorker.class);
    final ServerSocketChannalTransport sourceTransport = getTransport();


    public DefultSendWorker(BlockingQueue<SourceMessage> queue) throws IOException {

        poolExecutor = new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1));
        if (queue == null)
            throw new NullPointerException();
        this.queue = queue;
        channel = sourceTransport.getTransport();
    }


    void worker() {
        poolExecutor.execute(()->{
              for (;;){
                    if (!Thread.currentThread().isInterrupted() && !queue.isEmpty()) {
                        try {
                            if (channel != null) {
                                SourceMessage message = queue.take();
                                channel.write(message.getMessage());
                                message.getContext().ack();
                            }
                        } catch (IOException | InterruptedException e) {
                           logger.error("Failed to send message", e);
                        }
                    }
                }

        });
    }

    public void start(){
        if (queue == null)
            throw new NullPointerException();
        this.worker();
    }
}
