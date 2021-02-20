package com.vacancydiary.service.impl;

import com.vacancydiary.entity.User;
import com.vacancydiary.entity.Vacancy;
import com.vacancydiary.repository.UserRepository;
import com.vacancydiary.repository.VacancyRepository;
import com.vacancydiary.service.VacancyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class VacancyServiceImplTest {

    private final VacancyRepository vacancyRepository;
    private final EntityManager entityManager;
    private final VacancyService vacancyService;

    @Autowired
    public VacancyServiceImplTest(VacancyRepository vacancyRepository, EntityManager entityManager) {
        this.vacancyRepository = vacancyRepository;
        this.entityManager = entityManager;
        this.vacancyService = new VacancyServiceImpl(vacancyRepository, entityManager);
    }

    @Test
    void updateShouldUpdate() {
        Vacancy vacancy = Vacancy.vacancyBuilder().build();
        vacancyService.save(vacancy);

        vacancy.setCompanyName("updated");

        assertThat(vacancyService.update(vacancy)).isEqualTo(vacancy);
    }
}
