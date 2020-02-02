package com.sxlg.gbolet.network.worker;

import com.sxlg.goblet.channel.ChannelTransport;

import java.io.IOException;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public abstract class AbstractSendWorker {
    private ChannelTransport channelTransport = null;
    private ServerSocketChannel channel = ServerSocketChannel.open();

    public AbstractSendWorker() throws IOException {
        this.channelTransport = new ChannelTransport(channel);
        channel.socket().bind(new InetSocketAddress(9999));
    }
    abstract void worker();

    public ChannelTransport getChannelTransport() {
        return channelTransport;
    }
}
