package com.sxlg.gbolet.network.worker;

import com.sxlg.goblet.channel.ChannelTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefultSendWorker extends AbstractSendWorker{
    private static final Logger logger = LoggerFactory.getLogger(DefultSendWorker.class);
    private ThreadPoolExecutor poolExecutor = null;
    final private BlockingQueue<ByteBuffer> queue;
    private Channel channel = null;

    public DefultSendWorker(BlockingQueue<ByteBuffer> queue) throws IOException {

        poolExecutor = new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1));
        if (queue == null)
            throw new NullPointerException();
        this.queue = queue;
        final ChannelTransport channelTransport = getChannelTransport();
        channel = channelTransport.getTransport();

    }


    void worker() {
        poolExecutor.execute(()->{
              for (;;){
                    if (Thread.currentThread().isInterrupted() && !queue.isEmpty()) {
                        try {
                            if (channel != null)
                                ((SocketChannel) channel).write(queue.take());
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
        worker();
    }
}
