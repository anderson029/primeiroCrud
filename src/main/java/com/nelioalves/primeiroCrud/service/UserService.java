package com.nelioalves.primeiroCrud.service;

import com.nelioalves.primeiroCrud.dto.request.UserRequestCreateDto;
import com.nelioalves.primeiroCrud.dto.request.UserRequestQueryDto;
import com.nelioalves.primeiroCrud.dto.response.DepartamentResponseDto;
import com.nelioalves.primeiroCrud.dto.response.EnderecoResponseCreateDto;
import com.nelioalves.primeiroCrud.dto.response.UserResponseCreateDto;
import com.nelioalves.primeiroCrud.dto.response.UserResponseQueryDto;
import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.entities.Endereco;
import com.nelioalves.primeiroCrud.entities.User;
import com.nelioalves.primeiroCrud.exceptions.BusinessException;
import com.nelioalves.primeiroCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                .name(user.getName().trim())
                .email(user.getEmail())
                .departament(departamentEntity)
                .endereco(enderecoEntity)
                .build();
        //Salvando entidade no banco.
        User userSaved = userRepository.save(userEntity);
        // Convertendo a entidade em DTO.
        return UserResponseCreateDto.builder()//TODO criar nova classe para realizar o mapeamento de entidade para DTO
                .id(userSaved.getId())
                .name(userSaved.getName())
                .email(userSaved.getEmail())
                .departament(DepartamentResponseDto.builder()
                        .id(userSaved.getDepartament().getId())
                        .name(userSaved.getDepartament().getName())
                        .build())
                .endereco(EnderecoResponseCreateDto.builder()
                        .Id(userSaved.getEndereco().getId())
                        .rua(userSaved.getEndereco().getRua())
                        .numero(userSaved.getEndereco().getNumero())
                        .complemento(userSaved.getEndereco().getComplemento())
                        .bairro(userSaved.getEndereco().getBairro())
                        .cidade(userSaved.getEndereco().getCidade())
                        .estado(userSaved.getEndereco().getEstado())
                        .cep(userSaved.getEndereco().getCep())
                        .pais(userSaved.getEndereco().getPais())
                        .build())
                .build();
    }

    public UserResponseCreateDto findById(Long id) {
        Optional<User> entityOpt = userRepository.findById(id);
        if (entityOpt.isPresent()) {
            User entity = entityOpt.get();

            return UserResponseCreateDto.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .email(entity.getEmail())
                    .departament(DepartamentResponseDto.builder()
                            .id(entity.getDepartament().getId())
                            .name(entity.getDepartament().getName())
                            .build())
                    .endereco(EnderecoResponseCreateDto.builder()
                            .Id(entity.getEndereco().getId())
                            .rua(entity.getEndereco().getRua())
                            .numero(entity.getEndereco().getNumero())
                            .complemento(entity.getEndereco().getComplemento())
                            .bairro(entity.getEndereco().getBairro())
                            .cidade(entity.getEndereco().getCidade())
                            .estado(entity.getEndereco().getEstado())
                            .cep(entity.getEndereco().getCep())
                            .pais(entity.getEndereco().getPais())
                            .build())
                    .build();
        }
        return null;//TODO criar excepetions;
    }

    public List<UserResponseQueryDto> queryUser(UserRequestQueryDto request) {
        List<UserResponseQueryDto> users = new ArrayList<>();

        if (request.getName() == null && request.getEmail() == null) {
            List<User> userList = userRepository.findAll();
            if(userList.isEmpty()){
                throw new BusinessException("ADN-001","Usuário não encontrado!", HttpStatus.NOT_FOUND);
            }
            return listUser(userList);
        }

        if (request.getName() != null) {
            List<User> userList = userRepository.findByName(request.getName());
            if(userList.isEmpty()){
                throw new BusinessException("ADN-001","Usuário não encontrado!", HttpStatus.NOT_FOUND);
            }
            return listUser(userList);
        }

        if (request.getEmail() != null) {
            List<User> userList = userRepository.findByEmail(request.getEmail());
            if (userList.isEmpty()) {
                throw new BusinessException("ADN-001", "Usuário não encontrado!", HttpStatus.NOT_FOUND);
            }
            return listUser(userList);
        }

        List<User> userList = userRepository.findByNameOrEmail(request.getName(), request.getEmail());
        if (userList.isEmpty()) {
            if (userList.isEmpty()) {
                throw new BusinessException("ADN-001", "Usuário não encontrado!", HttpStatus.NOT_FOUND);
            }
            return listUser(userList);
        }
        return users;
    }

    public List<UserResponseQueryDto> listUser (List<User> userlist) {
        List<UserResponseQueryDto> dtos = new ArrayList<>();

        for (User user : userlist){
            dtos.add(UserResponseQueryDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .departament(DepartamentResponseDto.builder()
                            .id(user.getDepartament().getId())
                            .name(user.getDepartament().getName())
                            .build())
                    .endereco(EnderecoResponseCreateDto.builder()
                            .Id(user.getEndereco().getId())
                            .rua(user.getEndereco().getRua())
                            .numero(user.getEndereco().getNumero())
                            .complemento(user.getEndereco().getComplemento())
                            .bairro(user.getEndereco().getBairro())
                            .cidade(user.getEndereco().getCidade())
                            .estado(user.getEndereco().getEstado())
                            .cep(user.getEndereco().getCep())
                            .pais(user.getEndereco().getPais())
                            .build())
                    .build());
        }
        return dtos;
    }

//// Outras formas de realizar o FOR.
////        int index = 0;
////        while(index < listUsuario.size()){
////            User user = listUsuario.get(index);
////            dtos.add(new UserDto(user));
////        }
////
////        for(int i=0; i < listUsuario.size(); i++){
////            User user = listUsuario.get(i);
////            dtos.add(new UserDto(user));
////        }

    public UserResponseCreateDto updateUser(Long id, UserRequestCreateDto userRequestCreateDto){
        Optional<User> userOpt = userRepository.findById(id);

        if (userOpt.isPresent()){
            User userEntity = userOpt.get();
            userEntity.setName(userRequestCreateDto.getName());
            userEntity.setEmail(userRequestCreateDto.getEmail());
            userRepository.save(userEntity);
            UserResponseCreateDto updateResponse = UserResponseCreateDto.builder()
                    .id(userEntity.getId())
                    .name(userEntity.getName())
                    .email(userEntity.getEmail())
                    .departament(DepartamentResponseDto.builder()
                            .id(userEntity.getDepartament().getId())
                            .name(userEntity.getDepartament().getName())
                            .build())
                    .endereco(EnderecoResponseCreateDto.builder()
                            .Id(userEntity.getEndereco().getId())
                            .rua(userEntity.getEndereco().getRua())
                            .numero(userEntity.getEndereco().getNumero())
                            .complemento(userEntity.getEndereco().getComplemento())
                            .bairro(userEntity.getEndereco().getBairro())
                            .cidade(userEntity.getEndereco().getCidade())
                            .estado(userEntity.getEndereco().getEstado())
                            .cep(userEntity.getEndereco().getCep())
                            .pais(userEntity.getEndereco().getPais())
                            .build())
                    .build();
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




