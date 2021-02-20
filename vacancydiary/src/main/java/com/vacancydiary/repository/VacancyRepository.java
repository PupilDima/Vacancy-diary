package com.vacancydiary.repository;

import com.vacancydiary.entity.Vacancy;
import com.vacancydiary.entity.VacancyStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Integer>,
        PagingAndSortingRepository<Vacancy, Integer> {

    List<Vacancy> findAllByUserId(Integer userId, Pageable pageable);

    List<Vacancy> findAllByStatus(VacancyStatus status);

    Optional<Vacancy> findByCompanyName(String companyName);
}
