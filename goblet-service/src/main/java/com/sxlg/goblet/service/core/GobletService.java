package com.sxlg.goblet.service.core;

import com.sxlg.gbolet.network.worker.DefultAcceptWorket;
import com.sxlg.goblet.service.config.Configuration;
import com.sxlg.goblet.service.route.Router;

import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;

public class GobletService {
    private Configuration configuration = new Configuration();
    private DefultAcceptWorket acceptWorket = new DefultAcceptWorket();
    private BlockingQueue<ByteBuffer> queue = null;
    private Router router = null;

    public void beforeStart() {
        configuration.load();
        this.queue = acceptWorket.getSinkQueue();
        this.router = new Router(queue, configuration);
    }
    public void start() {
        acceptWorket.start();
    }



}
