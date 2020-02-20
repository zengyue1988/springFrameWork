package com.moon.integration.router.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@ComponentScan("com.moon.integration.router")
@IntegrationComponentScan("com.moon.integration.router")
@EnableIntegration
public class IntegrationConfiguration {
	
	  @Autowired
	  @Qualifier("inputChannel")
	  private MessageChannel inputChannel;
	    
	  @Autowired
	  @Qualifier("channelOne")
	  private MessageChannel channelOne;
	    
	  @Autowired
	  @Qualifier("channelTwo")
	  private MessageChannel channelTwo;
	  
	  @Bean
	  @Description("input Channel")
	  public MessageChannel inputChannel() {
	      return new DirectChannel();
	  }
	  @Bean
      @Description("channel One")
	  public MessageChannel channelOne() {
		  return new DirectChannel();
	  }
	  @Bean
	  @Description("channel Two")
	  public MessageChannel channelTwo() {
		  return new DirectChannel();
	  }
	  
	  @Router(inputChannel="inputChannel")
	  public String router(String name){
		  System.out.println("sayWhat:"+name);
		  return (name.equals("channel1")) ? "channelOne" : "channelTwo";   
	  }
	  
	  @ServiceActivator(inputChannel = "channelOne")
	  public void sayHello1(String name) {
		  System.out.println("Hello " + name + " this is channelOne");
	  }
    
	  @ServiceActivator(inputChannel = "channelTwo")
	  public void sayHello2(String name) {
		  System.out.println("Hello " + name + " this is channelTwo");
	  }

}