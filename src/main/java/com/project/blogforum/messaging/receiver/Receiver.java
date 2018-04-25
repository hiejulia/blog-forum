package com.project.blogforum.messaging.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private static final Logger log = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    // Receive message
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        log.info("[Received Message]:: " + message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}