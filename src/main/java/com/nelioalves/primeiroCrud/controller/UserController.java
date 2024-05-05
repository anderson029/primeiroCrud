package com.nelioalves.primeiroCrud.controller;

import com.nelioalves.primeiroCrud.dto.request.UserRequestCreateDto;
import com.nelioalves.primeiroCrud.dto.response.UserResponseCreateDto;
import com.nelioalves.primeiroCrud.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: Criar Swagger.
//TODO: Tratar os controllers com responseEntity.
@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    private UserService userService; //injetar automaticamente minha service

    @PostMapping
    public ResponseEntity<UserResponseCreateDto> createUsers(@RequestBody @Valid UserRequestCreateDto user){
        UserResponseCreateDto userResponseCreateDto = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseCreateDto);
    }

    //TODO: estudar paginação e implementar.
//    @GetMapping
//    public ResponseEntity<List<UserResponseCreateDto>> findAll() {
//        List<UserResponseCreateDto> users = userService.findAll();
//        return ResponseEntity.status(HttpStatus.OK).body(users);
//    }

    @GetMapping
    public ResponseEntity<List<UserResponseCreateDto>> findAll(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email
            ){

        UserRequestCreateDto request = UserRequestCreateDto.builder()
                .name(name)
                .email(email)
                .build();

        List<UserResponseCreateDto> users = userService.queryUser(request);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<UserResponseCreateDto> findbyId(@PathVariable Long id) {
        UserResponseCreateDto SingleUser = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(SingleUser);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseCreateDto> updateUser (@PathVariable Long id, @RequestBody UserRequestCreateDto user){
        UserResponseCreateDto updatedUser = userService.updateUser(id,user);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @DeleteMapping(value = "/{id}")
    public void removeUser(@PathVariable Long id){
        userService.removeUser(id);
    }
}