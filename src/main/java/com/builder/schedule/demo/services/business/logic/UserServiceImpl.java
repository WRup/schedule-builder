package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.Role;
import com.builder.schedule.demo.model.User;
import com.builder.schedule.demo.model.repository.RoleRepository;
import com.builder.schedule.demo.model.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user, String roleName) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role adminRole = roleRepository.findByRole("ADMIN");
        Role workerRole = roleRepository.findByRole("WORKER");
        if(roleName.equals("ADMIN")) {
            user.setRoles(new HashSet<>(Arrays.asList(adminRole, workerRole)));
        } else if(roleName.equals("WORKER")) {
            user.setRoles(new HashSet<>(Collections.singletonList(workerRole)));
        }

        userRepository.save(user);
    }
}
