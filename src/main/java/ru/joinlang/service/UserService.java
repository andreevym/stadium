package ru.joinlang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.joinlang.dao.UserDao;
import ru.joinlang.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<String> findAllUserNames() {
        return userDao.findAllUserNames();
    }

    public User getUserByUsername(String username) {
        return userDao.getByUsername(username);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }
}
