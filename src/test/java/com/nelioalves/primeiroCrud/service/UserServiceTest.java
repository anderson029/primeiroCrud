package com.nelioalves.primeiroCrud.service;

import com.nelioalves.primeiroCrud.dto.request.UserRequestCreateDto;
import com.nelioalves.primeiroCrud.dto.response.DepartamentResponseDto;
import com.nelioalves.primeiroCrud.dto.response.EnderecoResponseCreateDto;
import com.nelioalves.primeiroCrud.dto.response.UserResponseCreateDto;
import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.entities.Endereco;
import com.nelioalves.primeiroCrud.entities.User;
import com.nelioalves.primeiroCrud.repository.UserRepository;
import com.nelioalves.primeiroCrud.service.builders.DepartamentEntityBuilder;
import com.nelioalves.primeiroCrud.service.builders.EnderecoEntityBuilder;
import com.nelioalves.primeiroCrud.service.builders.UserEntityBuilder;
import com.nelioalves.primeiroCrud.service.builders.Dtos.UserRequestCreateDtoFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


// TODO: Finalizar teste unitários da service e criar novos...
// TODO: Criar README

class UserServiceTest {

    @Autowired
    @InjectMocks //Dizendo para mokito/junit utilizar os mocks na classe service
    private UserService userService;

    //@mock = mocando o comportamento do respositório sem usar o "original"
    @Mock
    private UserRepository userRepository;

    @Mock
    private DepartamentService departamentService;

    @Mock
    private EnderecoService enderecoService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Criando usuário com sucesso")
    void createUserTest() {
        UserRequestCreateDto request = UserRequestCreateDtoFixture.build();

        Endereco endereco = EnderecoEntityBuilder.build();
        Departament departament = DepartamentEntityBuilder.build();
        User user = UserEntityBuilder.build();

        when(enderecoService.findById(anyLong())).thenReturn(endereco);
        when(departamentService.findById(anyLong())).thenReturn(departament);
//        when(userRepository.save(any(User.class))).thenAnswer(argument -> argument.getArguments()[0]);
        when(userRepository.save(any(User.class))).thenReturn(user);


        UserResponseCreateDto response = userService.createUser(request);

        assertThat(response.getId()).isEqualTo(user.getId());
        assertThat(response.getName()).isEqualTo(request.getName());
        assertThat(response.getEmail()).isEqualTo(request.getEmail());
        assertThat(response.getDepartament()).isNotNull();
        assertThat(response.getDepartament().getId()).isEqualTo(request.getDepartamentId());

        verify(userRepository, times(1)).save(any(User.class));

    }

    @Test
    @DisplayName(value = " Consultar usuário com id válido")
    void findById() {
        User userEntity = UserEntityBuilder.build();

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(userEntity));

        UserResponseCreateDto response = userService.findById(1L);

        assertThat(response.getId()).isEqualTo(userEntity.getId());
        assertThat(response.getName()).isEqualTo(userEntity.getName());
        assertThat(response.getDepartament().getId()).isEqualTo(userEntity.getDepartament().getId());
        assertThat(response.getEndereco().getId()).isEqualTo(userEntity.getEndereco().getId());

        verify(userRepository, times(1)).findById(1L);

    }

    @Test
    @DisplayName(value = "Validar exception quando não retornar usuário")
    void findByIdWhenOptinalNull() {

        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        UserResponseCreateDto response = userService.findById(1L);

        assertNull(response);
        verify(userRepository, times(1)).findById(1L);

    }

    @Test
    @DisplayName(value = " Validar retorno de lista de usuários")
    void findAll() {

        List<User> userEntity = new ArrayList<>();
        userEntity.add(UserEntityBuilder.build());

        when(userRepository.findAll()).thenReturn(userEntity);

        List<UserResponseCreateDto> userList = userService.findAll();

        assertNotNull(userList);
        assertEquals(1, userList.size());
        assertEquals("Florisvaldo", userList.get(0).getName());

        verify(userRepository, times(1)).findAll();

    }

    @Test
    @DisplayName(value = "Validando retorno da lista nula")
    void findAllWhenNull(){

        when(userRepository.findAll()).thenReturn(null);

        List<UserResponseCreateDto> result = userService.findAll();

        assertNull(result);
        verify(userRepository, times(1)).findAll();
         // Arrumar o método real para retornar null caso a lista esteja vazia.
    }

    @Test
    void updateUser() {
    }

    @Test
    void removeUser() {
    }
}
