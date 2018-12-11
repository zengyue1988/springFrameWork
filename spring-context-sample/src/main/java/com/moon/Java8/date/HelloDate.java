package com.moon.Java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class HelloDate {

	public static void main(String[] args) {
		// local date time   get current date
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println(currentTime);
		System.out.println(currentTime.getMonth()+" "+currentTime.getDayOfMonth()+" "+currentTime.getSecond());
		// local date
		LocalDate date1 = currentTime.toLocalDate();
		System.out.println(date1);
		// local date time   get any date
		LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
		System.out.println(date2);
		// local date        get any date
		LocalDate date3 = LocalDate.of(2012, Month.OCTOBER, 12);
		System.out.println(date3);
		// local time        get any time
		LocalTime date4 = LocalTime.of(22, 15);
		System.out.println(date4);
		// local time        format time string
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println(date5);
		// zoned date time
		ZonedDateTime date6 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
		System.out.println(date6);
		// zone id
		ZoneId id = ZoneId.of("Europe/Paris");
		System.out.println(id);
		// current zone
		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println(currentZone);
	}

}
