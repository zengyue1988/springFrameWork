package com.moon.accessDate.Mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.moon.accessDate.Mybatis.entity.Student;

@Mapper
@Component
public interface StudentDao {
	
	@Select({"SELECT * FROM mb_student WHERE id = #{id}"})
    @Results(
    		id ="id",
            value = {
            		@Result(property = "courseList", column = "id", many = @Many(select = "com.moon.accessDate.Mybatis.dao.CourseDao.selectCoursesByStudentId")),
                    @Result(property = "id", column = "id")
            }
    )
    Student findStudentById(int id);

    @Select("SELECT * FROM mb_student")
    List<Student> findAllStudent();

}
