package com.sxlg.goblet.serializable;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import io.netty.buffer.ByteBuf;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class SerializationUtils {

    public ByteBuffer toBytes(Object o)  {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
       try {
           bos = new ByteArrayOutputStream();
           oos = new ObjectOutputStream(bos);
           oos.writeObject(o);
           oos.flush();
           ByteBuffer byteBuffer = ByteBuffer.wrap(bos.toByteArray());
           return byteBuffer;
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
          try {
              oos.close();
              bos.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
       }
       return null;
    }
    public Object toObject(ByteBuffer byteBuffer){
        byte[] bytes = byteBuffer.array();
        ByteArrayInputStream bim = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(bim);
            Object o = ois.readObject();
            return o;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try{
                ois.close();
                bim.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
