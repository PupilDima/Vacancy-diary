package com.vacancydiary.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Objects;

@ApiModel(description = "All details about the user.")
public class UserDto {

    @ApiModelProperty("User id.")
    Integer id;

    @ApiModelProperty("User email.")
    private String email;

    @ApiModelProperty("User password.")
    private String password;

    @ApiModelProperty("Vacancies for which the user applied.")
    List<VacancyDto> vacancies;

    public UserDto() {
    }

    public UserDto(Integer id, String email, String password, List<VacancyDto> vacancies) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.vacancies = vacancies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<VacancyDto> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<VacancyDto> vacancies) {
        this.vacancies = vacancies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDto userDto = (UserDto) o;

        return Objects.equals(id, userDto.id) &&
                Objects.equals(email, userDto.email) &&
                Objects.equals(password, userDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", vacancies=" + vacancies +
                '}';
    }
}
