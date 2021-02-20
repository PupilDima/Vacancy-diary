package com.vacancydiary.controller;

import com.vacancydiary.entity.VacancyStatus;
import com.vacancydiary.entity.dto.VacancyDto;
import com.vacancydiary.mapper.VacancyMapper;
import com.vacancydiary.service.VacancyService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class VacancyController {

    private static final int ITEMS = 5;

    private final VacancyService vacancyService;
    private final VacancyMapper vacancyMapper;

    public VacancyController(VacancyService vacancyService, VacancyMapper vacancyMapper) {
        this.vacancyService = vacancyService;
        this.vacancyMapper = vacancyMapper;
    }

    @GetMapping("/vacancies/user/{userId}/{page}")
    public List<VacancyDto> findAllByUserId(@PathVariable("userId") int userId, @PathVariable("page") int page) {
        return vacancyMapper.map(vacancyService.findAllByUserId(userId, PageRequest.of(page, ITEMS)));
    }

    @PutMapping("/vacancy/{id}")
    public VacancyDto update(@RequestBody VacancyDto vacancy) {
        return vacancyMapper.map(vacancyService.update(vacancyMapper.map(vacancy)));
    }

    @GetMapping("/vacancies/status/{status}")
    public List<VacancyDto> findAllByStatus(@PathVariable String status) {
        return vacancyMapper.map(vacancyService.findAllByStatus(VacancyStatus.valueOf(status.toUpperCase())));
    }

    @GetMapping("/vacancy/company-name/{companyName}")
    public VacancyDto findByCompanyName(@PathVariable String companyName) {
        return vacancyMapper.map(vacancyService.findByCompanyName(companyName));
    }
}
