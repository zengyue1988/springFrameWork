package com.moon.integration.aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
@ImportResource("/integration/aggregator.xml")
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplication(Application.class).run(args);
        MessageChannel channel = ctx.getBean("inputChannel", MessageChannel.class);
        Message<String> message1 = MessageBuilder.withPayload("Hello67").build();
        channel.send(message1);
        Message<String> message2 = MessageBuilder.withPayload("World67").build();
        channel.send(message2);
        Message<String> message3 = MessageBuilder.withPayload("release").build();
        channel.send(message3);
	}

}
