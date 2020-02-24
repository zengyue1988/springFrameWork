package com.moon.integration.splitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@ComponentScan("com.moon.integration.splitter")
@IntegrationComponentScan("com.moon.integration.splitter")
@EnableIntegration
public class IntegrationConfiguration {
	
	  @Autowired
	  @Qualifier("inputChannel")
	  private MessageChannel inputChannel;
	    
	  @Autowired
	  @Qualifier("speakerChannel")
	  private MessageChannel speakerChannel;
	  
	  @Bean
	  @Description("input Channel")
	  public MessageChannel inputChannel() {
	      return new DirectChannel();
	  }
	  @Bean
      @Description("speaker Channel")
	  public MessageChannel speakerChannel() {
		  return new DirectChannel();
	  }
	  
	  @Splitter(inputChannel="inputChannel",outputChannel="speakerChannel")
	  public Object splitter(String message){
		  System.out.println(message);
		  return message.split(",");
	  }
	  
	  @ServiceActivator(inputChannel = "speakerChannel")
	  public void sayHello1(String name) {
		  System.out.println("Hello " + name);
	  }

}