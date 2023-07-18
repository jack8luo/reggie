package com.luohao.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luohao.reggie.entity.Employee;
import com.luohao.reggie.entity.R;
import com.luohao.reggie.service.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @author luo
 * @version 1.0
 * @description: TODO
 * @date 2023/6/5 16:13
 */
@Slf4j //用于打印日志
@RestController // @RestController = @Controller + @ResponseBody
// @Controller是一个在Spring MVC框架中使用的注解，它的作用是将一个类标识为控制器（Controller）。控制器是用于处理客户端请求并返回响应的组件。
// @ResponseBody将方法返回值直接响应给浏览器
@RequestMapping("/employee")
// 提取公共的地址部分
public class EmployeeController {


    @Autowired
    private EmployeeServiceImpl employeeService;
    //登录功能
    @PostMapping("/login")
    public R<Employee> logib(HttpServletRequest request, @RequestBody Employee employee) {

        //1、将页面提交的密码进行md5加密处理
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2、根据页面提交的用户名来查数据库，mybatisplus写法
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();//LambdaQueryWrapper是MyBatis-Plus框架提供的一个用于构建查询条件的工具类。
        queryWrapper.eq(Employee::getUsername, employee.getUsername());//eq：生成一个等于(username = 'xxx')的查询条件
        Employee emp = employeeService.getOne(queryWrapper); //getOne方法会根据查询条件查询数据库

        //3、如果没有查询到则返回失败结果
        if (emp == null) {
            return R.error("登录失败");
        }

        //4、比对密码，如果不一致则返回失败结果
        if (!emp.getPassword().equals(password)) {
            return R.error("密码错误");
        }

        //5、查看员工状态，如果已禁用状态，则返回员工已禁用结果
        if (emp.getStatus() == 0) {
            return R.error("账号已禁用");
        }

        //6、登录成功，将用户id存入Session并返回成功结果
        request.getSession().setAttribute("employee", emp.getId());
        return R.success(emp);
    }


    //员工退出
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        //清理Session中保存的当前员工登录的id
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }


    //新增员工
    @PostMapping
    public R<String> save(HttpServletRequest request, @RequestBody Employee employee){//@RequestBody Employee employee用于接收前端传过来的对象

        log.info("新增员工，员工信息：{}",employee.toString());
        //设置初始密码，需要进行md5加密处理
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

        Long empId = (Long) request.getSession().getAttribute("employee");//获取当前登录用户的ID，之前登录的时候就向浏览器存了一个emp.getId()
        // request.getSession().getAttribute获取的都是Object对象，进行强转
        employee.setCreateUser(empId);
        employee.setUpdateUser(empId);

        employeeService.save(employee);//在数据持久层插入数据

        return R.success("新增员工成功");
    }

    //使用mybatisplus的分页插件实现分页功能
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        log.info("page={},pageSize={},name={}", page, pageSize, name);

        //构造分页构造器
        Page pageInfo=new Page(page,pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Employee> queryWrapper=new LambdaQueryWrapper();
        //添加过滤条件
        queryWrapper.like(!StringUtils.isEmpty(name),Employee::getName,name);
        //添加排序条件
        queryWrapper.orderByDesc(Employee::getUpdateTime);

        //执行查询
        employeeService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }

    //根据id修改员工信息
    @PutMapping
    public R<String> update(HttpServletRequest request,@RequestBody Employee employee){
        log.info(employee.toString());

        Long empId = (Long) request.getSession().getAttribute("employee");
        employee.setUpdateTime(LocalDateTime.now());
        employee.setUpdateUser(empId);
        employeeService.updateById(employee);

        return R.success("员工信息修改成功");
    }


    //根据id查询员工信息
    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable String id){
        log.info("根据id查对象");
        Employee emp = employeeService.getById(id);
        if(emp!=null){
            return R.success(emp);
        }
        return R.error("没有查询到该用户信息");
    }

}