package com.chaos.garden.service.biz;

import com.chaos.garden.dao.DishDao;
import com.chaos.garden.model.gen.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcfrank1st on 6/19/16.
 */
@Service
public class DishService {
    @Autowired private DishDao dishDao;

    public void addDish (Dish dish) { dishDao.addDish(dish); }

    public void updateDish (Dish dish) { dishDao.updateDish(dish); }

    public void deleteDish (int id) { dishDao.deleteDish(id); }

    public List<Dish> getDishes () { return dishDao.getDishes(); }
}
