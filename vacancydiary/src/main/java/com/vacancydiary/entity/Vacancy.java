package com.vacancydiary.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "vacancies")
public class Vacancy {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "expected_salary")
    private Integer expectedSalary;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "position")
    private String position;

    @Column(name = "vacancy_link")
    private String vacancyLink;

    @Embedded
    private RecruiterContact recruiterContact;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private VacancyStatus status;

    @Column(name = "last_status_change")
    private LocalDateTime lastStatusChange;

    protected Vacancy() {
    }

    private Vacancy(Integer id, Integer userId, String companyName, String position, Integer expectedSalary,
                    String vacancyLink, RecruiterContact recruiterContact, VacancyStatus status,
                    LocalDateTime lastStatusChange) {
        this.id = id;
        this.userId = userId;
        this.companyName = companyName;
        this.position = position;
        this.expectedSalary = expectedSalary;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public RecruiterContact getRecruiterContact() {
        return recruiterContact;
    }

    public void setRecruiterContact(RecruiterContact recruiterContact) {
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

    public static VacancyBuilder vacancyBuilder() {
        return new VacancyBuilder();
    }

    public static class VacancyBuilder {
        private Integer id;
        private Integer userId;
        private Integer expectedSalary;
        private String companyName;
        private String position;
        private String vacancyLink;
        private RecruiterContact recruiterContact;
        private VacancyStatus status;
        private LocalDateTime lastStatusChange;

        public VacancyBuilder setId(Integer id) {
            this.id = id;
            return this;
        }

        public VacancyBuilder setExpectedSalary(Integer expectedSalary) {
            this.expectedSalary = expectedSalary;
            return this;
        }

        public VacancyBuilder setPosition(String position) {
            this.position = position;
            return this;
        }

        public VacancyBuilder setVacancyLink(String vacancyLink) {
            this.vacancyLink = vacancyLink;
            return this;
        }

        public VacancyBuilder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public VacancyBuilder setRecruiterContact(RecruiterContact recruiterContact) {
            this.recruiterContact = recruiterContact;
            return this;
        }

        public VacancyBuilder setStatus(VacancyStatus status) {
            this.status = status;
            return this;
        }

        public VacancyBuilder setLastStatusChange(LocalDateTime lastStatusChange) {
            this.lastStatusChange = lastStatusChange;
            return this;

        }

        public VacancyBuilder setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Vacancy build() {
            return new Vacancy(id, userId, companyName, position, expectedSalary, vacancyLink, recruiterContact, status,
                    lastStatusChange);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;

        return Objects.equals(id, vacancy.id) &&
                Objects.equals(userId, vacancy.userId) &&
                Objects.equals(expectedSalary, vacancy.expectedSalary) &&
                Objects.equals(companyName, vacancy.companyName) &&
                Objects.equals(position, vacancy.position) &&
                Objects.equals(vacancyLink, vacancy.vacancyLink) &&
                status == vacancy.status &&
                Objects.equals(lastStatusChange, vacancy.lastStatusChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, expectedSalary, companyName, position, vacancyLink, recruiterContact, status,
                lastStatusChange);
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", userId=" + userId +
                ", expectedSalary=" + expectedSalary +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", vacancyLink='" + vacancyLink + '\'' +
                ", recruiterContact=" + recruiterContact +
                ", status=" + status +
                ", lastStatusChange=" + lastStatusChange +
                '}';
    }
}
