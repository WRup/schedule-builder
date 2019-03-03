package com.builder.schedule.demo.services.business.logic;


import com.builder.schedule.demo.model.User;

public interface UserService {
    User findUserByEmail(String email);

    void saveUser(User user);
}
