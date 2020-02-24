package com.moon.integration.fileChannelAdapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("/integration/fileChannelAdapter.xml")
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplication(Application.class).run(args);
	}

}
