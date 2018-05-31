package com.spring.restws.service;

import com.spring.restws.model.User;

import java.util.List;

public interface IUserService {
    public List<User> findAll();
    public User save(User user);
    public User findOne(Integer id);
    public User deleteById(Integer id);
}
