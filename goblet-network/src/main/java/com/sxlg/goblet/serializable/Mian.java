package com.sxlg.goblet.serializable;

import com.sxlg.gbolet.network.worker.DefultAcceptWorket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Mian {
    public static void main(String[] args) throws IOException {
        DefultAcceptWorket defultAcceptWorket = new DefultAcceptWorket();
        defultAcceptWorket.start();
//        SocketChannel open = SocketChannel.open();
//        open.connect(new InetSocketAddress("127.0.0.1",9999));
//        System.out.println(open.finishConnect());
//        ByteBuffer allocate = ByteBuffer.allocate(1024);
//
//        open.read(allocate);
//        System.out.println(allocate.position());
    }
}
