package com.moon.transactions.springTransaction.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BookingService {
	
	private final static Logger logger = LoggerFactory.getLogger(BookingService.class);

    private final JdbcTemplate jdbcTemplate;
    
    public BookingService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Transactional
    public void book(String... persons) {
    	for (String person : persons) {
    		logger.info("Booking " + person + " in a seat...");
    		jdbcTemplate.update("insert into BOOKINGS(FIRST_NAME) values (?)", person);
    	}
    }
    
    public List<String> findAllBookings(){
    	List<String> nameList = new ArrayList<String>();
    	//List<Map<String, Object>> rows = jdbcTemplate.queryForList("select FIRST_NAME from BOOKINGS");
    	List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from BOOKINGS");
    	for (Map<String, Object> row : rows) {
    		nameList.add((String) row.get("FIRST_NAME"));
    	}
    	return nameList;
    }

}
