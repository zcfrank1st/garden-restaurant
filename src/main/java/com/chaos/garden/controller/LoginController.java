package com.chaos.garden.controller;

import com.chaos.garden.model.Auth;
import com.chaos.garden.utils.Token;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.lang.JoseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zcfrank1st on 6/13/16.
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> login (@RequestBody Auth auth) throws JoseException {
        // TODO: 6/13/16 check login


        Map<String, String> token = new HashMap<>();
        token.put("token", Token.generateToken(auth));
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register (@RequestBody Auth auth) throws JoseException {
        // TODO: 6/13/16 register

        return new ResponseEntity<>("OK" , HttpStatus.OK);
    }

    // just demo
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public ResponseEntity<Auth> verify (HttpServletRequest request) throws InvalidJwtException {
        return new ResponseEntity<>(Token.verifyToken(request.getHeader("token")), HttpStatus.OK);
    }
}
