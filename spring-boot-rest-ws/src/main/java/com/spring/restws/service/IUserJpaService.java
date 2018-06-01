package com.spring.restws.service;

import java.util.List;

import com.spring.restws.domain.Post;
import com.spring.restws.domain.User;

public interface IUserJpaService {
    public List<User> findAll();
    public User save(User user);
    public User findOne(Integer id);
    public void deleteById(Integer id);
    public Post save(Post post);
}
