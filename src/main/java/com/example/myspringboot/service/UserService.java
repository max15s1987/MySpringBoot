package com.example.myspringboot.service;



import com.example.myspringboot.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void save(User user);
    void update(Long id, User user);
    void remove(Long id);
    User getUserById(Long id);
    boolean checkId(Long id);
}
