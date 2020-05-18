package com.sxlg.gbolet.network.worker;

import com.sxlg.goblet.network.channel.ServerSocketChannalTransport;
import com.sxlg.goblet.data.SourceMessage;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractSendWorker extends AbstractWorker{
    private ServerSocketChannalTransport sourceTransport = null;
    protected BlockingQueue<SourceMessage> queue;


    public AbstractSendWorker() throws IOException {
        this.sourceTransport = new ServerSocketChannalTransport();
    }


    public ServerSocketChannalTransport getTransport() {
        return sourceTransport;
    }
}
