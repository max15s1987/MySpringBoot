package com.example.myspringboot.dao;



import com.example.myspringboot.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    void save(User user);
    void update(Long id, User user);
    void remove(Long id);
    User getUserById(Long id);
    User findByLogin(String s);
    boolean checkId(Long id);
}
