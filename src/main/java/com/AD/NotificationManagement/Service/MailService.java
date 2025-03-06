package com.AD.NotificationManagement.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String fromId;

    public boolean getJavaMailSender(String recipient,String body,String title) throws MessagingException {
        MimeMessage message=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);

        //SimpleMailMessage message = new SimpleMailMessage();
    try {

        //helper.setFrom(fromId);
        //helper.setFrom(new InternetAddress("noreply@gmail.com", "Notification Service"));
       helper.setFrom("Notification Service <noreply@gmail.com>");
        



        helper.setTo(recipient);
        helper.setSubject(title);
        helper.setText(body);

        javaMailSender.send(message);
        return true;
    } catch (Exception e) {
        System.out.println("Error while sending mail: " + e.getMessage());


        return false;
    }

    }





    }

