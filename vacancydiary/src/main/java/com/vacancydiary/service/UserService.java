package com.vacancydiary.service;

import com.vacancydiary.entity.User;

public interface UserService {

    User save(User user);

    User findById(int userId);

    void deleteById(int userId);

    User update(User user);
}
