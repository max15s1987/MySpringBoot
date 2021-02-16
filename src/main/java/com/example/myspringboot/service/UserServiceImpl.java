package com.example.myspringboot.service;

import com.example.myspringboot.dao.UserDao;
import com.example.myspringboot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void save(User user) {
        userDao.save(user);
    }

    public void update(Long id, User user) {
        userDao.update(id, user);
    }

    public void remove(Long id) {
        userDao.remove(id);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public boolean checkId(Long id) {
        return userDao.checkId(id);
    }


}
