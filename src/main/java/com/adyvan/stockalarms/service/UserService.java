package com.adyvan.stockalarms.service;

import com.adyvan.stockalarms.model.User;
import com.adyvan.stockalarms.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}