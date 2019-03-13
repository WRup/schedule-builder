package com.builder.schedule.demo.model.repository;

import com.builder.schedule.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);

}
