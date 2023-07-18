package com.luohao.reggie.dto;

import com.luohao.reggie.entity.Setmeal;
import com.luohao.reggie.entity.SetmealDish;
import com.luohao.reggie.entity.Setmeal;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
