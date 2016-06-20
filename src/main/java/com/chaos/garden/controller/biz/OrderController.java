package com.chaos.garden.controller.biz;

import com.chaos.garden.model.OrderQuery;
import com.chaos.garden.model.gen.Order;
import com.chaos.garden.service.biz.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zcfrank1st on 6/18/16.
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity addOrder (@RequestBody Order order) {
        orderService.addOrder(order);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public ResponseEntity updateOrder (@RequestBody Order order) {
        orderService.updateOrder(order);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteOrder (@PathVariable("id") int id) {
        orderService.deleteOrder(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/self/orders", method = RequestMethod.GET)
    public ResponseEntity getSelfOrders () {
        // TODO
        return new ResponseEntity<>(orderService.getSelfOrders(1), HttpStatus.OK);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public ResponseEntity getOrders (@RequestBody OrderQuery orderQuery) {
        return new ResponseEntity<>(orderService.getOrders(orderQuery), HttpStatus.OK);
    }
}
