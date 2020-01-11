package com.sxlg.goblet.joyqueue.springboot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@ComponentScan(value = {"com.sxlg.goblet.joyqueue.consumer","com.sxlg.goblet.api.Impl"})
@SpringBootApplication
public class JoyQueueLaunch {
    protected static final Logger logger = LoggerFactory.getLogger(JoyQueueLaunch.class);

    public static void main(String[] args) {
        SpringApplication.run(JoyQueueLaunch.class);

    }
}
