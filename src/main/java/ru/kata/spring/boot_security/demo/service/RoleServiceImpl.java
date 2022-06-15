package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> getAllRoles() {
        return new HashSet<>(roleRepository.findAll());
    }

    @Override
    public Role getRole(String role) {
        return roleRepository.findByName(role);
    }

    @Override
    public Boolean saveRole(Role role) {
        if (roleRepository.findByName(role.getName()) == null) {
            roleRepository.save(role);
            return true;
        }
        return false;
    }
}
