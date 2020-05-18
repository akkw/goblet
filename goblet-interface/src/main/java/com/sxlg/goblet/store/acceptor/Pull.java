package com.sxlg.goblet.store.acceptor;

import com.sxlg.goblet.data.model.GobletRecord;
import io.openmessaging.message.Message;


public interface Pull {
    GobletRecord pares(Message message);
}
