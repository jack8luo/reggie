package com.luohao.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luohao.reggie.entity.Orders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService extends IService<Orders> {


    void submit(Orders orders);
}
