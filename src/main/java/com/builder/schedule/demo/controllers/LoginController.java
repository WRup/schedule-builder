package com.builder.schedule.demo.controllers;

import com.builder.schedule.demo.model.Role;
import com.builder.schedule.demo.model.User;
import com.builder.schedule.demo.services.business.logic.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/", "/login"})
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/login");
        return modelAndView;
    }

    @GetMapping(value = "/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        for (Role role : user.getRoles()) {
            if(role.getRole().equals("ADMIN")) {
                modelAndView.setViewName("admin/uploadFile");
                break;
            } else if(role.getRole().equals("WORKER")) {
                modelAndView.setViewName("worker/schedulerWorker");
            }
        }
        return modelAndView;
    }

    @GetMapping(value = "/access-denied")
    public ModelAndView accessDenied() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/access-denied");
        return modelAndView;
    }


}