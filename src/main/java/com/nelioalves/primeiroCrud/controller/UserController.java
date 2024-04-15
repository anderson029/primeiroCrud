package com.nelioalves.primeiroCrud.controller;

import com.nelioalves.primeiroCrud.dto.UserDto;
import com.nelioalves.primeiroCrud.entities.User;
import com.nelioalves.primeiroCrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService; //injetar automaticamente minha service

    @PostMapping
    public UserDto createUsers(@RequestBody UserDto user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserDto> findAll() {
       return userService.findAll();
    }

    @GetMapping(value="/{id}")
    public UserDto findbyId(@PathVariable Long id) {
        return userService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void removeUser(@PathVariable Long id){
        userService.removeUser(id);
    }
}