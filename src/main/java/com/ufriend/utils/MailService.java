package com.ufriend.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Data
public class MailService {

    @Autowired
    private JavaMailSender mailSender;
    
    @Value("${spring.mail.username}")
    private String from;

    public Boolean send(String to, String subject, String body) {

        Boolean sended;

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setText(body);
            message.setSubject(subject);
    
            mailSender.send(message);
            sended = true;
        } 
        catch(Exception e){
            log.error("Error enviando correo: " + e);
            sended = false;
        }

        return sended;
    }
}
