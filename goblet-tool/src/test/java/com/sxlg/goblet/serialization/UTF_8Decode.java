package com.sxlg.goblet.serialization;

import com.sxlg.goblet.deserialization.JoyMessageDeserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class UTF_8Decode {

    public static void main(String[] args) throws IOException {

        File file = new File("E:\\test.txt");
        FileInputStream  fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(10240);
        channel.read(byteBuffer);
        System.out.println(JoyMessageDeserialization.doDecoding(byteBuffer.array(),byteBuffer.position()));

    }
}
