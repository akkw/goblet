package com.sxlg.goblet.channel;

import com.sxlg.goblet.network.Transport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class SocketChannalTransport implements Transport {
    private static final Logger logger = LoggerFactory.getLogger(SocketChannalTransport.class);
    private static final String SERVER_HOST = "127.0.0.1";
    private static final int SERVER_PORT = 9999;

    public SocketChannel getChannel() {
        return channel;
    }

    private SocketChannel channel = null;

    public SocketChannalTransport() {
        try{
            this.channel = SocketChannel.open();
            channel.connect(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
        } catch (IOException e){
            logger.error("Connection exception");
        }
    }



}
