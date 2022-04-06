package com.example.springbootdemo311.dao;

import com.example.springbootdemo311.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager sessionFactory;


    public  void delete(Long id) {
        User us = sessionFactory.find(User.class, id);
        sessionFactory.remove(us);
    }

    public void update(Long id, String firstName, String lastName, String email) {
        User us = sessionFactory.find(User.class, id);
        us.setFirstName(firstName);
        us.setLastName(lastName);
        us.setEmail(email);
        sessionFactory.merge(us);
    }

    public void add(User user) {
        sessionFactory.persist(user);
    }

    public List<User> listUsers() {
        return sessionFactory.createQuery("select s from User s", User.class).getResultList();
    }
    public User findById(Long id) {
        return listUsers().stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
}

