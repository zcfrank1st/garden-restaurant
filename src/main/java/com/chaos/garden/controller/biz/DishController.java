package com.chaos.garden.controller.biz;

import com.chaos.garden.model.gen.Dish;
import com.chaos.garden.service.biz.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zcfrank1st on 6/18/16.
 */
@RestController
public class DishController {
    @Autowired private DishService dishService;

    @RequestMapping(value = "/dish", method = RequestMethod.POST)
    public ResponseEntity addDish (@RequestBody Dish dish) {
        dishService.addDish(dish);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/dish", method = RequestMethod.PUT)
    public ResponseEntity updateDish (@RequestBody Dish dish) {
        dishService.updateDish(dish);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/dish/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDish (@PathVariable("id") int id) {
        dishService.deleteDish(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/dishes", method = RequestMethod.GET)
    public ResponseEntity getDishes () {
        return new ResponseEntity<>(dishService.getDishes(), HttpStatus.OK);
    }

    // TODO: 6/19/16 get all dishes
    // show dished and catgories
}
