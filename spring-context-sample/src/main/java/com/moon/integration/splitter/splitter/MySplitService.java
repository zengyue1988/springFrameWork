package com.moon.integration.splitter.splitter;

import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;

public class MySplitService extends AbstractMessageSplitter {

	@Override
	protected Object splitMessage(Message<?> message) {
		System.out.println(message);
        String[] str = message.getPayload().toString().split(",");
        return str;
	}

}
