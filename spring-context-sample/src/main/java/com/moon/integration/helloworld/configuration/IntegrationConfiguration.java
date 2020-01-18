package com.moon.integration.helloworld.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@ComponentScan("com.moon.integration.helloworld")
@IntegrationComponentScan("com.moon.integration.helloworld")
@EnableIntegration
public class IntegrationConfiguration {
	
	@Autowired
    @Qualifier("helloChannel")
    private MessageChannel channel;

    @Bean
    @Description("Hello Channel")
    public MessageChannel helloChannel() {
        return new DirectChannel();
    }
    
    @ServiceActivator(inputChannel = "helloChannel")
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

}