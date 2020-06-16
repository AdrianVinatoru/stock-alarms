package com.adyvan.stockalarms.service;

import com.adyvan.stockalarms.dto.UserRegistrationDto;
import com.adyvan.stockalarms.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}