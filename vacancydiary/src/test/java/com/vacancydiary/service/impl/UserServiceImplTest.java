package com.vacancydiary.service.impl;

import com.vacancydiary.entity.User;
import com.vacancydiary.repository.UserRepository;
import com.vacancydiary.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class UserServiceImplTest {

    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final UserService userService;

    @Autowired
    public UserServiceImplTest(UserRepository userRepository, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
        this.userService = new UserServiceImpl(userRepository, entityManager);
    }

    @Test
    void updateShouldUpdate() {
        User user = new User(1, "mail", "pass", null);
        userService.save(user);
        user.setEmail("updated");

        assertThat(userService.update(user)).isEqualTo(user);
    }
}
