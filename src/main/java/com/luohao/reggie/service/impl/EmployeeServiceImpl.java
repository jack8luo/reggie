package com.luohao.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luohao.reggie.entity.Employee;
import com.luohao.reggie.mapper.EmployeeMapper;
import com.luohao.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author luo
 * @version 1.0
 * @description:
 * @date 2023/6/5 16:13
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}