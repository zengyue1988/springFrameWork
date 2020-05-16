package com.moon.accessDate.Mybatis.mapper;

import com.moon.accessDate.Mybatis.entity.Employee;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gf
 * @since 2020-05-15
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
