package com.luohao.reggie.common;

/**
 * @author luo
 * @version 1.0
 * @description: 自定义异常
 * @date 2023/6/6 20:16
 */
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}

