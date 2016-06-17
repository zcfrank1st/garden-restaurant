package com.chaos.garden.service;

import com.chaos.garden.model.Mail;
import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zcfrank1st on 6/16/16.
 */
@Service
@Slf4j
public class MailService {
    @Autowired
    private Config conf;

    private void sendMail(Mail mail, String template) throws EmailException, MalformedURLException {
        ImageHtmlEmail email = new ImageHtmlEmail();
        URL url = new URL("http://static.szechuangarden1986.com");
        email.setDataSourceResolver(new DataSourceUrlResolver(url));
        email.setHostName("szechuangarden1986.com");
        email.setAuthentication(conf.getString("mail.admin"),conf.getString("mail.passwd"));
        email.setCharset("UTF-8");
//        email.setSSLOnConnect(true);
        email.setHostName(conf.getString("mail.host"));
        email.setFrom(conf.getString("mail.from.addr"), conf.getString("mail.from.people"));
        email.addTo(mail.getToMail(), mail.getToPeople());
        email.setSubject(mail.getSubject());
        email.setHtmlMsg(template);
        email.setTextMsg("Your email client does not support HTML messages");
        email.send();
    }

    @Async
    public void sendTracePassMail (Mail mail) throws EmailException, MalformedURLException {
        // conf.getString("mail.trace.pass.template")
        sendMail(mail, "just for test, haha");
    }
}
