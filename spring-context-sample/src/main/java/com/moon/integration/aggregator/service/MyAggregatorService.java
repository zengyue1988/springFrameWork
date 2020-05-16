package com.moon.integration.aggregator.service;

import java.util.List;

public class MyAggregatorService {

	public List<String> aggregator(List<String> reqs) {
        System.out.println(reqs);
        return reqs;
    }

}
