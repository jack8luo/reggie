package com.luohao.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luohao.reggie.entity.User;
import com.luohao.reggie.mapper.UserMapper;
import com.luohao.reggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author luo
 * @version 1.0
 * @description: TODO
 * @date 2023/7/18 11:02
 */
@Service
//Spring可以自动检测通过@Service注解标记的类，并将其注册为Spring应用上下文中的bean。
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
