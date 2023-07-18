package com.luohao.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luohao.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {//继承mybatisplus的接口中的众多数据库查询方法
}

