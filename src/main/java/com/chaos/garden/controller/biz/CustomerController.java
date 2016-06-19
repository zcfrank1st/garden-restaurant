package com.chaos.garden.controller.biz;

import com.chaos.garden.model.gen.Customer;
import com.chaos.garden.service.biz.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zcfrank1st on 6/18/16.
 */
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

//    @RequestMapping(value = "/customer", method = RequestMethod.POST)
//    public ResponseEntity addCustomer (@RequestBody Customer customer) {
//        customerService.addCustomer(customer);
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public ResponseEntity updateCustomer (@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCustomer (@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity getCustomers () {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }
}
