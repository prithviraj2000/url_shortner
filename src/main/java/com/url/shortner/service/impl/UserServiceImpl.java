package com.url.shortner.service.impl;

import com.url.shortner.entity.User;
import com.url.shortner.repository.UserRepository;
import com.url.shortner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

     @Override
     public String createUser(String originalUrl) {
          //User user = new User();
         return"";

     }
}
