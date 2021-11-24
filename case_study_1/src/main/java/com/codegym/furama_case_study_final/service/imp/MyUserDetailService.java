package com.codegym.furama_case_study_final.service.imp;

import com.codegym.furama_case_study_final.dto.MyUserDetail;
import com.codegym.furama_case_study_final.model.User;
import com.codegym.furama_case_study_final.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username doesn't exist!");
        }
        return new MyUserDetail(user);
    }
}
