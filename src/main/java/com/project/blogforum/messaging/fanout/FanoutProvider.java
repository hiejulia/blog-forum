package com.project.blogforum.messaging.fanout;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


public class FanoutProvider {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Scheduled(initialDelay=1000, fixedDelay=50000000)
    public void test2(){
        //send message to quueu
        rabbitTemplate.convertAndSend("testFanoutModeExchange", "key2", "testFanoutModeExchangekey2");
    }
}