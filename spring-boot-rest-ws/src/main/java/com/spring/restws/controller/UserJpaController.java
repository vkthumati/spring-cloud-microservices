package com.spring.restws.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.restws.domain.Post;
import com.spring.restws.domain.User;
import com.spring.restws.exceptions.UserNotFoundException;
import com.spring.restws.service.IUserJpaService;

@RestController
public class UserJpaController {
    @Autowired
    private IUserJpaService userService;

    @GetMapping(path = "/users/jpa/{id}")
    public Resource<User> findOne(@PathVariable Integer id){
        User user =  userService.findOne(id);
        if(user==null)
            throw new UserNotFoundException("id-"+id);

        //"all-users", SERVER_PATH + "/users"

        //HATEOAS
        Resource<User> resource = new Resource<>(user);

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());

        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @GetMapping(path = "/users/jpa")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping(path = "/users/jpa")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser =  userService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @PostMapping(path = "/users/jpa/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable Integer id,  @Valid @RequestBody Post post){
    	User user = userService.findOne(id);
        
    	post.setUser(user);
    	Post savedPost = userService.save(post);
    	
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @DeleteMapping(path = "/users/jpa/{id}")
    public void deleteById(@PathVariable Integer id){
        userService.deleteById(id);
    }
    
    @GetMapping(path = "/users/jpa/{id}/posts")
    public List<Post> findAllPosts(@PathVariable Integer id){
        User user = userService.findOne(id);
        return user.getPost();
    }

}
