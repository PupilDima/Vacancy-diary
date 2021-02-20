package com.vacancydiary.service.impl;


import com.vacancydiary.entity.UserSecurityDetails;
import com.vacancydiary.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        return new UserSecurityDetails(userService.findByEmail(email));
    }
}
