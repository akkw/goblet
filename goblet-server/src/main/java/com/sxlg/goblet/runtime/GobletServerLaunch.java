package com.sxlg.goblet.runtime;

import com.sxlg.goblet.service.config.Configuration;
import com.sxlg.goblet.service.core.GobletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GobletServerLaunch {
    private static Logger logger = LoggerFactory.getLogger(GobletServerLaunch.class);
    public static void main(String[] args) {

        GobletService gobletService = new GobletService();
        gobletService.beforeStart();
        gobletService.start();
    }
}
