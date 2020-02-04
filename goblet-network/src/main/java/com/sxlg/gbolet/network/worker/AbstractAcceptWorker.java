package com.sxlg.gbolet.network.worker;

import com.sxlg.goblet.channel.SocketChannalTransport;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractAcceptWorker extends AbstractWorker{
    SocketChannalTransport sinkTransport = null;
    protected BlockingQueue<ByteBuffer> queue;

    public AbstractAcceptWorker() throws IOException {
        this.sinkTransport = new SocketChannalTransport();
    }

    public SocketChannel getTransport(){
        return sinkTransport.getChannel();
    }
}
