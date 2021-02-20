package com.vacancydiary.repository;


import com.vacancydiary.entity.RecruiterContact;
import com.vacancydiary.entity.User;
import com.vacancydiary.entity.Vacancy;
import com.vacancydiary.entity.VacancyStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class VacancyRepositoryTest {

    private final VacancyRepository vacancyRepository;
    private final UserRepository userRepository;

    @Autowired
    VacancyRepositoryTest(VacancyRepository vacancyRepository, UserRepository userRepository) {
        this.vacancyRepository = vacancyRepository;
        this.userRepository = userRepository;
    }

    @Test
    void findAllByUsersIdShouldFindAllVacancyByUserId() {
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

        User user = new User(1, "email@email", "password", Arrays.asList(vacancy1, vacancy2));
        userRepository.save(user);

        vacancy1.setId(1);
        vacancy2.setId(2);
        List<Vacancy> expected = Arrays.asList(vacancy1, vacancy2);
        List<Vacancy> actual = vacancyRepository.findAllByUserId(1, PageRequest.of(0, 5));

        assertThat(actual).containsAll(expected);
    }

    @Test
    void findAllByStatusShouldFindAllVacancyByStatus() {
        Vacancy vacancy1 = Vacancy.vacancyBuilder()
                .setCompanyName("company")
                .setPosition("position")
                .setExpectedSalary(1234)
                .setVacancyLink("link.com")
                .setStatus(VacancyStatus.OFFER)
                .setRecruiterContact(new RecruiterContact("hremail", "777-777-777"))
                .setLastStatusChange(LocalDateTime.now())
                .build();
        Vacancy vacancy2 = Vacancy.vacancyBuilder()
                .setCompanyName("company2")
                .setPosition("position2")
                .setExpectedSalary(1234)
                .setVacancyLink("link2.com")
                .setStatus(VacancyStatus.OFFER)
                .setRecruiterContact(new RecruiterContact("hremail2", "777-777-777"))
                .setLastStatusChange(LocalDateTime.now())
                .build();

        vacancyRepository.save(vacancy1);
        vacancyRepository.save(vacancy2);

        List<Vacancy> expected = Arrays.asList(vacancy1, vacancy2);
        assertThat(vacancyRepository.findAllByStatus(VacancyStatus.OFFER)).isEqualTo(expected);
    }

    @Test
    void findByCompanyNameShouldFindVacancyByCompanyName() {
        String companyName = "company";
        Vacancy expected = Vacancy.vacancyBuilder()
                .setCompanyName(companyName)
                .setPosition("position")
                .setExpectedSalary(1234)
                .setVacancyLink("link.com")
                .setStatus(VacancyStatus.OFFER)
                .setRecruiterContact(new RecruiterContact("hremail", "777-777-777"))
                .setLastStatusChange(LocalDateTime.now())
                .build();

        vacancyRepository.save(expected);

        assertThat(vacancyRepository.findByCompanyName(companyName)).isEqualTo(expected);
    }
}