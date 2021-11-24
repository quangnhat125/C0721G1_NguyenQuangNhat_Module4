package com.codegym.furama_case_study_final.repository;

import com.codegym.furama_case_study_final.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
