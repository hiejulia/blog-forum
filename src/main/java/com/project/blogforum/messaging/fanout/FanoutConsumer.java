package com.project.blogforum.messaging.fanout;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;


@RabbitListener(queues = "testFanoutModeQueue", containerFactory = "rabbitListenerContainerFactory")
public class FanoutConsumer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    static  int i = 0;


    @RabbitHandler
    public void process3(@Payload String msg) throws Exception{
        logger.warn("testFanout " + ": " + msg + (i++));
    }

}