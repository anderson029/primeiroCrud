package com.nelioalves.primeiroCrud.service;

import com.nelioalves.primeiroCrud.dto.UserDto;
import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.entities.User;
import com.nelioalves.primeiroCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO: Refatorar para utilizar Lombok.
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
        return new UserDto(userSaved);
    }

    public UserDto findById(Long id) {
        User entity = userRepository.findById(id).get();
        return new UserDto(entity);
    }

    public List<UserDto> findAll() {
        List<User> listUsuario = userRepository.findAll();
        List<UserDto> dtos = new ArrayList<>();

// Outras formas de realizar o FOR.
//        int index = 0;
//        while(index < listUsuario.size()){
//            User user = listUsuario.get(index);
//            dtos.add(new UserDto(user));
//        }
//
//        for(int i=0; i < listUsuario.size(); i++){
//            User user = listUsuario.get(i);
//            dtos.add(new UserDto(user));
//        }

        for (User user : listUsuario) {
            dtos.add(new UserDto(user));
        }
        return dtos;
    }

    public UserDto updateUser(Long id, UserDto userDto){
        Optional<User> userOpt = userRepository.findById(id);

        if (userOpt.isPresent()){
            User userEntity = userOpt.get();
            userEntity.setName(userDto.getName());
            userEntity.setEmail(userDto.getEmail());
            userRepository.save(userEntity);
            UserDto updateUser = new UserDto(userEntity);
            return updateUser;
        }
        else  {
            System.out.println("Usuário não encontrado"); //TODO: Implementar exceptions.
            return null;
        }
    }

    public void removeUser(Long id) {
         userRepository.deleteById(id);
    }
}




