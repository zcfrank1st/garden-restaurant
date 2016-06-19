package com.chaos.garden.controller.biz;

import com.chaos.garden.model.gen.Customer;
import com.chaos.garden.service.TokenService;
import com.chaos.garden.service.biz.CustomerService;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zcfrank1st on 6/13/16.
 */
@RestController
public class LoginController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> login (@RequestBody Customer customer) throws JoseException {
        List<Customer> customerList = customerService.checkCustomer(customer);
        if (customerList.size() == 1) {
            Map<String, String> token = new HashMap<>();
            token.put("token", tokenService.generateToken(customerList.get(0)));
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            throw new RuntimeException("no such person");
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register (@RequestBody Customer customer) throws JoseException {
        customerService.addCustomer(customer);
        return new ResponseEntity<>("OK" , HttpStatus.OK);
    }

    // just demo
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public ResponseEntity<Customer> verify (HttpServletRequest request) throws InvalidJwtException {
        return new ResponseEntity<>(tokenService.verifyToken(request.getHeader("token")), HttpStatus.OK);
    }
}
