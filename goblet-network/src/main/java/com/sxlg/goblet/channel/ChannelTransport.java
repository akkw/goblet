package com.sxlg.goblet.channel;

import com.sxlg.goblet.network.Transport;

import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;

public class ChannelTransport implements Transport {

    private Channel channel = null;


    public ChannelTransport(Channel channel) {
        this.channel = channel;
    }

    public Channel getTransport() throws IOException {
        return ((ServerSocketChannel) channel).accept();
    }
}
