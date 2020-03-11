package com.sxlg.goblet.acceptor;

import com.sxlg.goblet.model.GobletRecord;
import io.openmessaging.message.Message;


public interface Pull {
    GobletRecord fetch(Message message);
}
