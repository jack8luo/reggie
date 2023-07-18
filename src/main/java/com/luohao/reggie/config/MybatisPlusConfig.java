package com.luohao.reggie.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author luo
 * @version 1.0
 * @description: TODO
 * @date 2023/6/5 20:42
 */
//mybatisplus分页查询插件
@Configuration //表示是配置类,通过@Configuration配置类，可以实现应用程序的灵活配置和组装。
//而@Configuration底层就是@Component,所以配置类最终也是SpringIOC容器当中的一个bean对象

public class MybatisPlusConfig {
    @Bean//放入IOC容器中
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return  mybatisPlusInterceptor;
    }
}
