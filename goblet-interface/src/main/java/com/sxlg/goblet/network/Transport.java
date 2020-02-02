package com.sxlg.goblet.network;

import java.io.IOException;
import java.nio.channels.Channel;

public interface Transport {
    Channel getTransport() throws IOException;

}
