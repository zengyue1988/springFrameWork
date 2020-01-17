package com.moon.mq.activemq.configuration;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfiguration {
	
	@Bean
    public Queue queue() {
       return new ActiveMQQueue("sample.queue");
    }

}