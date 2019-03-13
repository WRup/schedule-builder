package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.Role;
import com.builder.schedule.demo.model.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveRole(String roleName) {
        Role role = new Role();
        role.setRole(roleName);
        roleRepository.save(role);
    }
}
