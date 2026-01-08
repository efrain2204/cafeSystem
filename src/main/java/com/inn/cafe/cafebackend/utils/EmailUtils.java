package com.inn.cafe.cafebackend.utils;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailUtils {

    private JavaMailSender emailSender;

    public EmailUtils(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(String to, String subject, String text,List<String> list) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("efra.cripto@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        if(list !=null && !list.isEmpty())
            message.setCc(getCcArray(list));
        emailSender.send(message);
    }

    private String[] getCcArray(List<String> ccList){
        String[] cc = new String[ccList.size()];
        for (int i = 0; i < ccList.size(); i++) {
            cc[i] = ccList.get(i);
        }
        return cc;
    }

    public void forgotEmail(String to, String subject, String password) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("efra.cripto@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        String htmlMsg = "Correo de olvidar contraseña" + password;
        message.setContent(htmlMsg, "text/html; charset=utf-8");
        emailSender.send(message);
    }
}
