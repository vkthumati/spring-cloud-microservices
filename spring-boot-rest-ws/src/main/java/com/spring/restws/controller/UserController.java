package com.spring.restws.controller;

import com.spring.restws.exceptions.UserNotFoundException;
import com.spring.restws.model.User;
import com.spring.restws.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(path = "/users/{id}")
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

    @GetMapping(path = "/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> save(@Valid @RequestBody User user){
        User savedUser =  userService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteById(@PathVariable Integer id){
        User user = userService.deleteById(id);
        if(user==null)
            throw new UserNotFoundException("id-"+id);
    }

}
