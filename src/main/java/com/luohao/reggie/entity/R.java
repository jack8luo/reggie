package com.luohao.reggie.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luo
 * @version 1.0
 * @description: 此类是一个通用结果类，服务端响应的所有结果最终都会包装成此种类型返回给前端页面
 * @date 2023/6/5 16:16
 */
@Data
public class R<T> {//<T>是范型，泛型允许你在编写代码时使用一种抽象的方式来处理不同类型的数据，而不需要为每种类型编写重复的代码。

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
