package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findById(Integer id);

    User findByeMail(String email);

    List<User> findAll();

    boolean saveUser(User user);

    boolean deleteById(Integer id);
}
