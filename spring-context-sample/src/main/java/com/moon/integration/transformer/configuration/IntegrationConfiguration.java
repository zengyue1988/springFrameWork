package com.moon.integration.transformer.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@ComponentScan("com.moon.integration.transformer")
@IntegrationComponentScan("com.moon.integration.transformer")
@EnableIntegration
public class IntegrationConfiguration {
	
	  @Autowired
	  @Qualifier("inputChannel")
	  private MessageChannel inputChannel;
	    
	  @Bean
      @Description("Input Channel")
      public MessageChannel inputChannel() {
          return new DirectChannel();
      }
	  @Bean
      @Description("hello Channel")
	  public MessageChannel helloChannel() {
		  return new DirectChannel();
	  }
	  
	  @Transformer(inputChannel = "inputChannel",outputChannel="helloChannel")
	  public String check(String message){
	      return message+"!!!!";
	  }
	  
	  @ServiceActivator(inputChannel = "helloChannel")
	  public void sayHello(String name) {
		  System.out.println("Hello " + name );
	  }
    
	  @ServiceActivator(inputChannel = "channelTwo")
	  public void sayHello2(String name) {
		  System.out.println("Hello " + name + " this is channelTwo");
	  }

}