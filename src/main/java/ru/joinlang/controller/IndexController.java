package ru.joinlang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.joinlang.model.User;
import ru.joinlang.service.UserService;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private UserService ldapService;

    @RequestMapping("/user")
    public UsernamePasswordAuthenticationToken user(UsernamePasswordAuthenticationToken user) {
        return user;
    }

    @RequestMapping("/allNameOfUsers")
    public List<String> findAllUserName() {
        return ldapService.findAllUserNames();
    }

    @RequestMapping("/allUsers")
    public List<User> getAllUsers() {
        return ldapService.getAll();
    }

    @RequestMapping("/isAuthenticated")
    public boolean isAuthenticated(UsernamePasswordAuthenticationToken user) {
        return user.isAuthenticated();
    }
}
