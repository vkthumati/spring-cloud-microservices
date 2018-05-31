package com.spring.restws.service.impl;

import com.spring.restws.dao.IUserDao;
import com.spring.restws.model.User;
import com.spring.restws.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;

    public List<User> findAll(){
        return dao.findAll();
    }

    public User save(User user){

        return dao.save(user);
    }

    public User findOne(Integer id){
        return dao.findOne(id);
    }

    public User deleteById(Integer id){
        return dao.deleteById(id);
    }
}
