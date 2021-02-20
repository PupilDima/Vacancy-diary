package com.vacancydiary.service.impl;

import com.vacancydiary.entity.Vacancy;
import com.vacancydiary.entity.VacancyStatus;
import com.vacancydiary.repository.VacancyRepository;
import com.vacancydiary.service.VacancyService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;
    private final EntityManager entityManager;

    public VacancyServiceImpl(VacancyRepository vacancyRepository, EntityManager entityManager) {
        this.vacancyRepository = vacancyRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Vacancy save(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    @Override
    public Vacancy findById(int id) {
        return vacancyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                String.format("Vacancy with id: %d not found", id)));
    }

    @Override
    public List<Vacancy> findAllByUserId(Integer userId, Pageable pageable) {
        return vacancyRepository.findAllByUserId(userId, pageable);
    }

    @Override
    public List<Vacancy> findAllByStatus(VacancyStatus status) {
        return vacancyRepository.findAllByStatus(status);
    }

    @Override
    public Vacancy findByCompanyName(String companyName) {
        return vacancyRepository.findByCompanyName(companyName).orElseThrow(() -> new EntityNotFoundException(
                String.format("Vacancy with such company name: %s not found", companyName)));
    }

    @Override
    @Transactional
    public Vacancy update(Vacancy vacancy) {
        return entityManager.merge(vacancy);
    }
}
