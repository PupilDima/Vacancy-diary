package com.vacancydiary.controller;

import com.vacancydiary.service.EmailService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/send-email")
public class MailController {

    private final EmailService emailService;

    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/{subject}/{text}")
    public void sendMessage(@PathVariable String subject, @PathVariable String text) {
        emailService.sendMessageToUsersWaitingFeedback(subject, text);
    }
}
