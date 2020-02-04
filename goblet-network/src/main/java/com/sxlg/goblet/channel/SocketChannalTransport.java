package com.sxlg.goblet.channel;

import com.sxlg.goblet.network.Transport;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class SocketChannalTransport implements Transport {
    private static final String SERVER_HOST = "127.0.0.1";
    private static final int SERVER_PORT = 9999;

    public SocketChannel getChannel() {
        return channel;
    }

    private SocketChannel channel = null;

    public SocketChannalTransport() throws IOException {
        this.channel = SocketChannel.open();
        channel.connect(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
    }



}
