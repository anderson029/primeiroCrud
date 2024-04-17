package com.nelioalves.primeiroCrud.controller;

import com.nelioalves.primeiroCrud.dto.UserDto;
import com.nelioalves.primeiroCrud.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: Criar Swagger.
//TODO: Tratar os controllers com responseEntity.
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService; //injetar automaticamente minha service

    @PostMapping
    public ResponseEntity<UserDto> createUsers(@RequestBody @Valid UserDto user){
        UserDto userDto = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    //TODO: estudar paginação e implementar.
    @GetMapping
    public List<UserDto> findAll() {
       return userService.findAll();
    }

    @GetMapping(value="/{id}")
    public UserDto findbyId(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public UserDto updateUser (@PathVariable Long id, @RequestBody UserDto user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping(value = "/{id}")
    public void removeUser(@PathVariable Long id){
        userService.removeUser(id);
    }
}