package com.moon.integration.aggregator.aggregator;

import java.util.List;

public class MyReleaseStrategy {

	public boolean canRelease(List<String> messages) {
		return messages.contains("release");
	}

}
