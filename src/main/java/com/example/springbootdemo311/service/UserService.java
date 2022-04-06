package com.example.springbootdemo311.service;

import com.example.springbootdemo311.dao.UserDao;
import com.example.springbootdemo311.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Transactional
    public void update(Long id, String firstName, String lastName, String email) {
        userDao.update(id, firstName, lastName, email);
    }

    @Transactional
    public User findById(Long id) {
        User user = userDao.findById(id);
        return user;
    }
}
