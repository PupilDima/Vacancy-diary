package com.vacancydiary.service.impl;

import com.vacancydiary.service.EmailService;
import com.vacancydiary.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;
    private final UserService userService;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public EmailServiceImpl(JavaMailSender emailSender, UserService userService) {
        this.emailSender = emailSender;
        this.userService = userService;
    }

    @Override
    public void sendMessageToUsersWaitingFeedback(String subject, String text) {
        userService.findAllByVacanciesWaitingFeedback().forEach(user -> {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(user.getEmail());
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
        });
    }
}
