package com.moon.accessDate.Mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.moon.accessDate.Mybatis.entity.Course;

@Mapper
@Component
public interface CourseDao {
	
	@Insert("INSERT INTO mb_course (`name`,`teacher`) VALUES (#{name},#{teacher})")
    int insertCourse(Course course);

    @Select("SELECT * FROM mb_course WHERE id IN (SELECT course_id FROM mb_score WHERE student_id = #{studentId})")
    List<Course> selectCoursesByStudentId(@Param("studentId") int studentId);

}
