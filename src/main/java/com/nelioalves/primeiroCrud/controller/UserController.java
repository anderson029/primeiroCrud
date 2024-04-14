package com.nelioalves.primeiroCrud.controller;

import com.nelioalves.primeiroCrud.dto.UserDTO;
import com.nelioalves.primeiroCrud.entities.User;
import com.nelioalves.primeiroCrud.repository.UserRepository;
import com.nelioalves.primeiroCrud.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private ServiceUser user;

    @PostMapping
    public UserDTO createUsers(@RequestBody UserDTO user){
         User response = new ServiceUser();
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
