package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entities.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
    void addRole(Role role);
    Role getRole(String userRole);
}
