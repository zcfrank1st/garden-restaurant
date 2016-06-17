package com.chaos.garden.controller;

import com.chaos.garden.model.Mail;
import com.chaos.garden.service.MailService;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

/**
 * Created by zcfrank1st on 6/17/16.
 */
@RestController
public class SendMailController {
    @Autowired
    private MailService mailService;

    @RequestMapping(method = RequestMethod.POST, value = "/mail/trace")
    public ResponseEntity sendTraceMail (@RequestBody Mail mail) throws MalformedURLException, EmailException {
        mailService.sendTracePassMail(mail);
        return new ResponseEntity(HttpStatus.OK);
    }
}
