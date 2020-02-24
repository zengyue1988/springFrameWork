package com.moon.integration.channelAdapter.input;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
@ImportResource("/integration/channelAdapter.xml")
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplication(Application.class).run(args);
        MessageChannel channel = ctx.getBean("inboundChannel", MessageChannel.class);
        Message<String> message = MessageBuilder.withPayload("World").build();
        channel.send(message);
	}

}
