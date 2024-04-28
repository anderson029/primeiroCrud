package com.nelioalves.primeiroCrud.controller;

import com.nelioalves.primeiroCrud.dto.request.UserRequestCreateDto;
import com.nelioalves.primeiroCrud.dto.response.UserResponseCreateDto;
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
    public ResponseEntity<UserResponseCreateDto> createUsers(@RequestBody @Valid UserRequestCreateDto user){
        UserResponseCreateDto userResponseCreateDto = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseCreateDto);
    }

    //TODO: estudar paginação e implementar.
    @GetMapping
    public List<UserResponseCreateDto> findAll() {
       return userService.findAll();
    }

    @GetMapping(value="/{id}")
    public UserResponseCreateDto findbyId(@PathVariable Long id) {
        return userService.findById(id);

    }

    @PutMapping(value = "/{id}")
    public UserResponseCreateDto updateUser (@PathVariable Long id, @RequestBody UserRequestCreateDto user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping(value = "/{id}")
    public void removeUser(@PathVariable Long id){
        userService.removeUser(id);
    }
}