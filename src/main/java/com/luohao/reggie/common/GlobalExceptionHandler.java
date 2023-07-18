package com.luohao.reggie.common;

import com.luohao.reggie.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author luo
 * @version 1.0
 * @description: 全局异常处理器
 * @date 2023/6/5 20:31
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class}) //表示RestController、Controller的注解controller都会被拦截到
@ResponseBody // @ResponseBody将方法返回值直接响应给浏览器
@Slf4j

public class GlobalExceptionHandler {


    //异常：java.sql.SQLIntegrityConstraintViolationException: Duplicate entry 'heniang' for key 'idx_username'
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    //进行异常处理方法
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());

        if(ex.getMessage().contains("Duplicate entry")){
            String[] split = ex.getMessage().split(" ");
            String msg=split[2]+"已存在";
            return R.error(msg);
        }

        return R.error("未知错误");
    }

    //进行异常处理方法
    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandler(CustomException ex){
        log.error(ex.getMessage());

        return R.error(ex.getMessage());
    }
}
