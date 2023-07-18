package com.luohao.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luohao.reggie.entity.OrderDetail;
import com.luohao.reggie.mapper.OrderDetailMapper;
import com.luohao.reggie.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * @author luo
 * @version 1.0
 * @description: TODO
 * @date 2023/7/18 14:11
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
