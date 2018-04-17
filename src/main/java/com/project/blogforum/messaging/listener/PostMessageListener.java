package com.project.blogforum.messaging.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;

/**
 * This is the queue listener class, its receiveMessage() method ios invoked with the
 * message as the parameter.
 */
@Component
public class PostMessageListener {

    private static final Logger log = LogManager.getLogger(PostMessageListener.class);i


    public void receiveMessage(Map<String, String> message) {
        log.info(message);
        Long id = Long.valueOf(message.get("id"));
        log.info("Message processed..."+id);
    }
}
