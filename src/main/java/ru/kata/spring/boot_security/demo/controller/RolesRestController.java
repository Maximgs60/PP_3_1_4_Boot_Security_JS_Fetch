package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.service.RoleService;

import java.util.Set;

@RestController
public class RolesRestController {
    private final RoleService roleService;

    @Autowired
    public RolesRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/api/roles")
    public Set<Role> roleSet() {
        return roleService.getAllRoles();
    }
}
