package com.chaos.garden.dao;

import com.chaos.garden.dao.mapper.gen.DishMapper;
import com.chaos.garden.model.gen.Dish;
import com.chaos.garden.model.gen.DishExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcfrank1st on 6/19/16.
 */
@Repository
public class DishDao {
    @Autowired private DishMapper dishMapper;

    public void addDish (Dish dish) {
        dishMapper.insertSelective(dish);
    }

    public void updateDish (Dish dish) {
        dishMapper.updateByPrimaryKeySelective(dish);
    }

    public void deleteDish (int id) {
        dishMapper.deleteByPrimaryKey(id);
    }

    public List<Dish> getDishes () {
        DishExample example = new DishExample();
        return dishMapper.selectByExample(example);
    }
}
