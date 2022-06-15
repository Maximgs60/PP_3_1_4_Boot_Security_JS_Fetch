package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class FillingDB {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public FillingDB(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public  void initialFillingDB() {
        User admin = new User("admin", "adminovich", "admin@mail.ru", 15, "admin");
        User user = new User("user", "userovich", "user@mail.ru", 18, "user");
        Role roleAdmin = new Role(1, "ROLE_ADMIN");
        Role roleUser = new Role(2, "ROLE_USER");

        roleService.saveRole(roleUser);
        roleService.saveRole(roleAdmin);

        Set<Role> roles = new HashSet<>();

        roles.add(roleUser);
        user.setRoles(roles);
        userService.saveUser(user);

        roles.add(roleAdmin);
        admin.setRoles(roles);
        userService.saveUser(admin);
    }
}
