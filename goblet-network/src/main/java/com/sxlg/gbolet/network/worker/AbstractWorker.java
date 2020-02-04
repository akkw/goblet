package com.sxlg.gbolet.network.worker;

import java.nio.channels.SocketChannel;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class AbstractWorker {
    protected SocketChannel channel = null;

    protected ThreadPoolExecutor poolExecutor = null;

    abstract void worker();
}
