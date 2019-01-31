package com.builder.schedule.demo.services.business.logic;

public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);
}
