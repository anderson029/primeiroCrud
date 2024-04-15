package com.nelioalves.primeiroCrud.service;

import com.nelioalves.primeiroCrud.dto.UserDto;
import com.nelioalves.primeiroCrud.entities.User;
import com.nelioalves.primeiroCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; //importar automaticamente minha interface

    public User createUser(User user){
        User pessoa = userRepository.save(user);
        return pessoa;
    }
    public UserDto findById(Long id) {
        User entity = userRepository.findById(id).get();
        UserDto dto = new UserDto(entity);
        return dto;
    }

    public List<UserDto> findAll(){
        List<User> listUsuario = userRepository.findAll();
        List<UserDto> dtos = new ArrayList<>();
        for (User user : listUsuario) {
            UserDto dto = new UserDto(user);
            dtos.add(dto);
        }
        return dtos;
    }

}



