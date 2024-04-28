package com.nelioalves.primeiroCrud.service;

import com.nelioalves.primeiroCrud.dto.request.UserRequestCreateDto;
import com.nelioalves.primeiroCrud.dto.response.UserResponseCreateDto;
import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.entities.Endereco;
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

    @Autowired
    private EnderecoService enderecoService;

    public UserResponseCreateDto createUser(UserRequestCreateDto user) {
        //Transformando DTO em entidade.
        Endereco enderecoEntity = enderecoService.findById(user.getEnderecoId());
        Departament departamentEntity = departamentService.findById(user.getDepartamentId());
        User userEntity = User.builder()
                .id(null)
                .name(user.getName())
                .email(user.getEmail())
                .departament(departamentEntity)
                .endereco(enderecoEntity)
                .build();
        //Salvando entidade no banco.
        User userSaved = userRepository.save(userEntity);
        // Convertendo a entidade em DTO.
        return new UserResponseCreateDto(userSaved);
    }

    public UserResponseCreateDto findById(Long id) {
        User entity = userRepository.findById(id).get();
        return new UserResponseCreateDto(entity);
    }

    public List<UserResponseCreateDto> findAll() {
        List<User> listUsuario = userRepository.findAll();
        List<UserResponseCreateDto> dtos = new ArrayList<>();

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
            dtos.add(new UserResponseCreateDto(user));
        }
        return dtos;
    }

    public UserResponseCreateDto updateUser(Long id, UserRequestCreateDto userRequestCreateDto){
        Optional<User> userOpt = userRepository.findById(id);

        if (userOpt.isPresent()){
            User userEntity = userOpt.get();
            userEntity.setName(userRequestCreateDto.getName());
            userEntity.setEmail(userRequestCreateDto.getEmail());
            userRepository.save(userEntity);
            UserResponseCreateDto updateResponse = new UserResponseCreateDto(userEntity);
            return updateResponse;
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




