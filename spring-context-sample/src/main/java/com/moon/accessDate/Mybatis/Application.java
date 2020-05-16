package com.moon.accessDate.Mybatis;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.moon.accessDate.Mybatis.dao.CourseDao;
import com.moon.accessDate.Mybatis.dao.StudentDao;
import com.moon.accessDate.Mybatis.entity.Course;
import com.moon.accessDate.Mybatis.entity.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplication(Application.class).run(args);
		StudentDao studentDao = ctx.getBean("studentDao", StudentDao.class);
		CourseDao courseDao = ctx.getBean("courseDao", CourseDao.class);
		List<Student> studentList = studentDao.findAllStudent();
		Student student = studentDao.findStudentById(1);
		List<Course> corseList = courseDao.selectCoursesByStudentId(1);
		System.out.println(student);
		System.out.println(studentList);
		System.out.println(corseList);
	}
	
}
