package com.spring.restws.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.restws.dao.IPostRepository;
import com.spring.restws.dao.IUserJpaRepository;
import com.spring.restws.domain.Post;
import com.spring.restws.domain.User;
import com.spring.restws.exceptions.UserNotFoundException;
import com.spring.restws.service.IUserJpaService;

@Service
public class UserJpaServiceImpl implements IUserJpaService {

    @Autowired
    private IUserJpaRepository repository;
    
    @Autowired
    private IPostRepository postRepository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User save(User user){

        return repository.save(user);
    }

    public User findOne(Integer id){
    	Optional<User> user = repository.findById(id); 
    	 if(!user.isPresent()) {
         	throw new UserNotFoundException("Id : "+id);
         }
        return user.get();
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    
    @Override
    public Post save(Post post) {
    	return postRepository.save(post);
    }
}
