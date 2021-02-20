package com.vacancydiary.service;

import com.vacancydiary.entity.Vacancy;
import com.vacancydiary.entity.VacancyStatus;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VacancyService {

    Vacancy save(Vacancy vacancy);

    Vacancy findById(int id);

    List<Vacancy> findAllByUserId(Integer userId, Pageable pageable);

    List<Vacancy> findAllByStatus(VacancyStatus status);

    Vacancy findByCompanyName(String companyName);

    Vacancy update(Vacancy vacancy);
}
