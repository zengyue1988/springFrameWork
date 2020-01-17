package com.moon.mq.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MqConsumer {
	
	@JmsListener(destination = "sample.queue")
    public void receiveQueue(String text) {
       System.out.println(text);
    }
	
}