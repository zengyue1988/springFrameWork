package com.moon.accessDate.Mybatis.entity;

import java.util.List;

import lombok.Data;

@Data
public class Student {

	private int id;
    private String code;
    private String name;
    private String age;
    private String phoneNo;
    private List<Course> courseList;
	
}
