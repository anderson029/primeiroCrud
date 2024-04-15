package com.nelioalves.primeiroCrud.service;

import com.nelioalves.primeiroCrud.dto.UserDto;
import com.nelioalves.primeiroCrud.entities.Departament;
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

    @Autowired
    private DepartamentService departamentService;

    public UserDto createUser(UserDto user) {
        //Transformando DTO em entidade.
        Departament departamentEntity = departamentService.findById(user.getDepartament().getId());
        User userEntity = new User(user.getId(), user.getName(), user.getEmail(), departamentEntity);

        //Salvando entidade no banco.
        User userSaved = userRepository.save(userEntity);
        // Convertendo a entidade em DTO.
        UserDto userDto = new UserDto(userSaved);

        return userDto;
    }

    public UserDto findById(Long id) {
        User entity = userRepository.findById(id).get();
        UserDto dto = new UserDto(entity);
        return dto;
    }

    public List<UserDto> findAll() {
        List<User> listUsuario = userRepository.findAll();
        List<UserDto> dtos = new ArrayList<>();
        for (User user : listUsuario) {
            UserDto dto = new UserDto(user);
            dtos.add(dto);
        }
        return dtos;
    }

    public void removeUser(Long id) {
         userRepository.deleteById(id);
    }
}




