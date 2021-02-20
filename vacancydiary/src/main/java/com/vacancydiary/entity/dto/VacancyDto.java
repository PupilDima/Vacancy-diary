package com.vacancydiary.entity.dto;

import com.vacancydiary.entity.VacancyStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.Objects;

@ApiModel(description = "All details about the vacancy.")
public class VacancyDto {

    @ApiModelProperty("Vacancy id.")
    private Integer id;

    @ApiModelProperty("Expected salary of user on the vacancy.")
    private Integer expectedSalary;

    @ApiModelProperty("Name of company.")
    private String companyName;

    @ApiModelProperty("Position in company.")
    private String position;

    @ApiModelProperty("Link on vacancy.")
    private String vacancyLink;

    @ApiModelProperty("All details about the recruiter contact.")
    private RecruiterContactDto recruiterContact;

    @ApiModelProperty("Vacancy status.")
    private VacancyStatus status;

    @ApiModelProperty("Last date of vacancy status change.")
    private LocalDateTime lastStatusChange;

    public VacancyDto() {
    }

    public VacancyDto(Integer id, Integer expectedSalary, String companyName, String position, String vacancyLink,
                      RecruiterContactDto recruiterContact, VacancyStatus status, LocalDateTime lastStatusChange) {
        this.id = id;
        this.expectedSalary = expectedSalary;
        this.companyName = companyName;
        this.position = position;
        this.vacancyLink = vacancyLink;
        this.recruiterContact = recruiterContact;
        this.status = status;
        this.lastStatusChange = lastStatusChange;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(Integer expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getVacancyLink() {
        return vacancyLink;
    }

    public void setVacancyLink(String vacancyLink) {
        this.vacancyLink = vacancyLink;
    }

    public RecruiterContactDto getRecruiterContact() {
        return recruiterContact;
    }

    public void setRecruiterContact(RecruiterContactDto recruiterContact) {
        this.recruiterContact = recruiterContact;
    }

    public VacancyStatus getStatus() {
        return status;
    }

    public void setStatus(VacancyStatus status) {
        this.status = status;
    }

    public LocalDateTime getLastStatusChange() {
        return lastStatusChange;
    }

    public void setLastStatusChange(LocalDateTime lastStatusChange) {
        this.lastStatusChange = lastStatusChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VacancyDto that = (VacancyDto) o;

        return Objects.equals(id, that.id) &&
                Objects.equals(expectedSalary, that.expectedSalary) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(position, that.position) &&
                Objects.equals(vacancyLink, that.vacancyLink) &&
                status == that.status &&
                Objects.equals(lastStatusChange, that.lastStatusChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, expectedSalary, companyName, position, vacancyLink, recruiterContact,
                status, lastStatusChange);
    }
}
