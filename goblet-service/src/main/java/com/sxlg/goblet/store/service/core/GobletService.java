package com.sxlg.goblet.store.service.core;

import com.sxlg.gbolet.network.worker.DefultAcceptWorket;
import com.sxlg.goblet.store.service.config.Configuration;
import com.sxlg.goblet.store.service.route.RouterConfig;
import com.sxlg.goblet.store.service.route.SouterExecutor;

import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;

public class GobletService {
    private Configuration configuration = new Configuration();
    private DefultAcceptWorket acceptWorket = new DefultAcceptWorket();
    private BlockingQueue<ByteBuffer> queue = null;
    private RouterConfig router = null;
    private SouterExecutor sqlExecutor = null;

    public void beforeStart() {
        configuration.load();
        this.queue = acceptWorket.getSinkQueue();
        this.router = new RouterConfig(queue, configuration);
        this.sqlExecutor =  new SouterExecutor(router);
    }
    public void start() {
        acceptWorket.start();
        new Thread(sqlExecutor).start();
    }



}
