package com.luohao.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luohao.reggie.dto.DishDto;
import com.luohao.reggie.entity.Dish;
import org.springframework.transaction.annotation.Transactional;

public interface DishService extends IService<Dish> {


    @Transactional
    void saveWithFlavor(DishDto dishDto);
    @Transactional
    DishDto getByIdWithFlavor(Long id);
    @Transactional
    void updateWithFlavor(DishDto dishDto);
}
