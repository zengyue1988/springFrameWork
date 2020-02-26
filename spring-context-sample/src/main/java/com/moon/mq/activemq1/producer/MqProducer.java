package com.moon.mq.activemq1.producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class MqProducer {
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Autowired
	private Queue queue;
	
	@Scheduled(fixedDelay=3000) // send message per 3 seconds
    public void send() {
       this.jmsMessagingTemplate.convertAndSend(this.queue, "hi, activeMQ");
    }

}