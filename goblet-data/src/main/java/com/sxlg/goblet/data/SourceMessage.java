package com.sxlg.goblet.data;

import io.openmessaging.consumer.MessageListener;

import java.nio.ByteBuffer;

public class SourceMessage {
    private ByteBuffer message;
    private MessageListener.Context context;

    public SourceMessage(ByteBuffer message, MessageListener.Context context) {
        this.context = context;
        this.message = message;
    }

    public MessageListener.Context getContext() {
        return context;
    }

    public void setContext(MessageListener.Context context) {
        this.context = context;
    }

    public ByteBuffer getMessage() {
        return message;
    }

    public void setMessage(ByteBuffer message) {
        this.message = message;
    }
}
