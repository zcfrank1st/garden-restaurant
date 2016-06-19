package com.chaos.garden.service.biz;

import com.chaos.garden.dao.CategoryDao;
import com.chaos.garden.model.gen.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcfrank1st on 6/18/16.
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public void addCategory (Category category) {
        categoryDao.addCategory(category);
    }


    public void deleteCategory (int id) {
        categoryDao.deleteCategory(id);
    }


    public void updateCategory (Category category) {
        categoryDao.updateCategory(category);
    }


    public List<Category> getCategories () {
        return categoryDao.getCategories();
    }
}
