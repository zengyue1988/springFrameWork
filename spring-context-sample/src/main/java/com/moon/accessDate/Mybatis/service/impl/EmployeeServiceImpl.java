package com.moon.accessDate.Mybatis.service.impl;

import com.moon.accessDate.Mybatis.entity.Employee;
import com.moon.accessDate.Mybatis.mapper.EmployeeMapper;
import com.moon.accessDate.Mybatis.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gf
 * @since 2020-05-15
 */
@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
