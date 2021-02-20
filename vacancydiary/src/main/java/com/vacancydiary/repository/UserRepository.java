package com.vacancydiary.repository;

import com.vacancydiary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    @Query(value = "SELECT * FROM users u JOIN vacancies v ON v.user_id = u.id " +
            "WHERE v.status = 'WAITING_FEEDBACK' " +
            "AND v.last_status_change < curdate() - INTERVAL DAYOFWEEK(curdate())+ 7 DAY;"
            , nativeQuery = true)
    List<User> findAllByVacanciesWaitingFeedback();
}
