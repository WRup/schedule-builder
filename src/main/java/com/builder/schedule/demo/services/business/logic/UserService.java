package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
