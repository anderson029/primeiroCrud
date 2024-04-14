package com.nelioalves.primeiroCrud.controller;


import com.nelioalves.primeiroCrud.entities.User;
import com.nelioalves.primeiroCrud.repository.UserRepository;
import com.nelioalves.primeiroCrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired //importar automaticamente minha interface
    private UserRepository repository;
//private final UserService userService;

//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//    @PostMapping
//    public User createUsers(@RequestBody User user){
//        return userService.createUser(user);
//    }

    @PostMapping
    public User createUsers(@RequestBody User user){
        return repository.save(user);
    }

    @GetMapping
    public List<User> findAll() {
        List<User> result = repository.findAll();
        return result;
    }

    @GetMapping(value="/{id}")
    public User findbyId(@PathVariable Long id) {
        User result = repository.findById(id).get();
        return result;
    }



}
