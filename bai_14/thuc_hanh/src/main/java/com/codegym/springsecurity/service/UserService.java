package com.codegym.springsecurity.service;

import com.codegym.springsecurity.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
