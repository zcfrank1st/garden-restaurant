package com.chaos.garden.controller.biz;

import com.chaos.garden.model.gen.Category;
import com.chaos.garden.service.biz.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zcfrank1st on 6/18/16.
 */
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResponseEntity addCategory (@RequestBody Category category) {
        categoryService.addCategory(category);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.POST)
    public ResponseEntity deleteCategory (@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT)
    public ResponseEntity updateCategory (@RequestBody Category category) {
        categoryService.updateCategory(category);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity getCategories () {
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }
}
