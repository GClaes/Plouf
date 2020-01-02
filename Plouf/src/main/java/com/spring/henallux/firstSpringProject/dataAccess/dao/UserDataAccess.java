package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserDataAccess extends UserDetailsService {
    User save (User user);
    UserDetails loadUserByUsername(String s);
    List<User> getUsers();
}
