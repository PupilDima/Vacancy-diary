package com.vacancydiary.service;

import com.vacancydiary.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User findById(int userId);

    void deleteById(int userId);

    User update(User user, int id);

    User findByEmail(String email);

    List<User> findAllByVacanciesWaitingFeedback();

}
