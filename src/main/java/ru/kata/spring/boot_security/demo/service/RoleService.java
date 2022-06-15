package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.Set;

public interface RoleService {

    Set<Role> getAllRoles();

    Role getRole(String role);

    Boolean saveRole(Role role);

}
