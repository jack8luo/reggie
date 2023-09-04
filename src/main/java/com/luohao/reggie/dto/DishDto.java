package com.luohao.reggie.dto;

import com.luohao.reggie.entity.Dish;
import com.luohao.reggie.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/*
* Data Transfer object数据传输对象，一般用于展示层与服务层之间的数据传输。
* */
@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;

}
