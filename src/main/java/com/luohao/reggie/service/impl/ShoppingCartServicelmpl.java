package com.luohao.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luohao.reggie.entity.ShoppingCart;
import com.luohao.reggie.mapper.ShoppingCartMapper;
import com.luohao.reggie.service.ShoppingCartService;
import org.springframework.stereotype.Service;

/**
 * @author luo
 * @version 1.0
 * @description: TODO
 * @date 2023/7/18 13:37
 */
@Service
public class ShoppingCartServicelmpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
