package com.sxlg.goblet.runtime;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"com.sxlg.goblet.api.Impl","com.sxlg.goblet.source"})
@SpringBootApplication
public class GobletLaunch {
    protected static final Logger logger = LoggerFactory.getLogger(GobletLaunch.class);
    public static void main(String[] args) {
        SpringApplication.run(GobletLaunch.class);
    }
}
