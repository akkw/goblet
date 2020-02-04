package com.sxlg.goblet.data;

import io.openmessaging.consumer.MessageListener;

import java.nio.ByteBuffer;

public class SourceMessage {
    private ByteBuffer buffer;
    private MessageListener.Context context;

    public SourceMessage( ByteBuffer buffer, MessageListener.Context context) {
        this.context = context;
        this.buffer = buffer;
    }

    public MessageListener.Context getContext() {
        return context;
    }

    public void setContext(MessageListener.Context context) {
        this.context = context;
    }

    public ByteBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(ByteBuffer buffer) {
        this.buffer = buffer;
    }
}
