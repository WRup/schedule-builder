package com.builder.schedule.demo.common;

import com.builder.schedule.demo.model.User;
import com.builder.schedule.demo.services.business.logic.RoleService;
import com.builder.schedule.demo.services.business.logic.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class InitLoader implements ApplicationRunner {

    private UserService userService;
    private RoleService roleService;

    public InitLoader(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        roleService.saveRole("ADMIN");
        roleService.saveRole("WORKER");

        User admin = new User();
        admin.setPassword("janek123");
        admin.setEmail("admin@scheduler.com");
        admin.setName("Jan");
        admin.setLastName("Jankowski");
        admin.setActive(1);
        userService.saveUser(admin, "ADMIN");

        User worker = new User();
        worker.setPassword("prowadzacy123");
        worker.setEmail("worker@scheduler.com");
        worker.setName("Maria");
        worker.setLastName("Kowalska");
        worker.setActive(1);
        userService.saveUser(worker, "WORKER");
    }
}
