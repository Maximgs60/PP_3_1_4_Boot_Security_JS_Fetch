package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UsersRestController {

    private final UserService userService;

    @Autowired
    public UsersRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping("")
    public User addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping("")
    public User updateUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
