package com.vacancydiary.service;

public interface EmailService {

    void sendMessageToUsersWaitingFeedback(String subject, String text);
}
