package com.example.myspringboot.service;

import com.example.myspringboot.dao.UserDao;
import com.example.myspringboot.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDao userDao;

    public CustomUserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user= userDao.findByLogin(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Unknown user: "+userName);
        }
        return user;
    }

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return userDao.findByLogin(s);
//    }

}
