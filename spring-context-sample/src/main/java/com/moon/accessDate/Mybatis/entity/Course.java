package com.moon.accessDate.Mybatis.entity;

import java.util.List;

import lombok.Data;

@Data
public class Course {

    private int id;
    private String name;
    private String teacher;
    private List<Student> studentList;
	
}
