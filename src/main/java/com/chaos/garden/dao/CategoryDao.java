package com.chaos.garden.dao;

import com.chaos.garden.dao.mapper.gen.CategoryMapper;
import com.chaos.garden.model.gen.Category;
import com.chaos.garden.model.gen.CategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcfrank1st on 6/18/16.
 */
@Repository
public class CategoryDao {
    @Autowired
    private CategoryMapper categoryMapper;


    public void addCategory (Category category) {
        categoryMapper.insertSelective(category);
    }


    public void deleteCategory (int id) {
        categoryMapper.deleteByPrimaryKey(id);
    }


    public void updateCategory (Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }


    public List<Category> getCategories () {
        CategoryExample example = new CategoryExample();
        return categoryMapper.selectByExample(example);
    }
}
