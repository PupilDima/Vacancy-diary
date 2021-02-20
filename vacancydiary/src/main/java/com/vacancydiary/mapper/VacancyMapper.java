package com.vacancydiary.mapper;

import com.vacancydiary.entity.Vacancy;
import com.vacancydiary.entity.dto.VacancyDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper(componentModel = "spring")
public interface VacancyMapper {

    VacancyDto map(Vacancy vacancy);

    Vacancy map(VacancyDto vacancyDto);

    default List<VacancyDto> map(List<Vacancy> vacancies) {
        return vacancies.stream().map(this::map).collect(Collectors.toList());
    }

    default List<Vacancy> mapToListVacancies(List<VacancyDto> vacanciesDto) {
        return vacanciesDto.stream().map(this::map).collect(Collectors.toList());
    }
}
