package com.vacancydiary.service.impl;

import com.vacancydiary.entity.RecruiterContact;
import com.vacancydiary.entity.User;
import com.vacancydiary.entity.Vacancy;
import com.vacancydiary.entity.VacancyStatus;
import com.vacancydiary.repository.UserRepository;
import com.vacancydiary.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.Arrays;

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
        Vacancy vacancy1 = Vacancy.vacancyBuilder()
                .setUserId(1)
                .setCompanyName("company")
                .setPosition("position")
                .setExpectedSalary(1234)
                .setVacancyLink("link.com")
                .setStatus(VacancyStatus.GAVE_TEST)
                .setRecruiterContact(new RecruiterContact("hremail", "777-777-777"))
                .setLastStatusChange(LocalDateTime.parse("2021-01-21T12:30"))
                .build();
        User user = new User(1, "mail", "pass", Arrays.asList(vacancy1));
        userService.save(user);
        user.setEmail("updated");

        Vacancy vacancy2 = Vacancy.vacancyBuilder()
                .setUserId(1)
                .setCompanyName("company2")
                .setPosition("position2")
                .setExpectedSalary(1234)
                .setVacancyLink("link2.com")
                .setStatus(VacancyStatus.OFFER)
                .setRecruiterContact(new RecruiterContact("hremail2", "777-777-777"))
                .setLastStatusChange(LocalDateTime.parse("2021-01-21T12:30"))
                .build();
        user.setVacancies(Arrays.asList(vacancy2));

        assertThat(userService.update(user, 1)).isEqualTo(user);
    }
}
