package com.nelioalves.primeiroCrud.service;

import com.nelioalves.primeiroCrud.dto.request.UserRequestCreateDto;
import com.nelioalves.primeiroCrud.dto.response.UserResponseCreateDto;
import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.entities.User;
import com.nelioalves.primeiroCrud.repository.UserRepository;
import com.nelioalves.primeiroCrud.service.fixtures.DepartamentFixture;
import com.nelioalves.primeiroCrud.service.fixtures.UserRequestCreateDtoFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


class UserServiceTest {

    @Autowired
    @InjectMocks //Dizendo para mokito/junit utilizar os mocks na classe service
    private UserService userService;

    //@mock = mocando o comportamento do respositório sem usar o "original"

    @Mock
    private UserRepository userRepository;

    @Mock
    private DepartamentService departamentService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Criando usuário com sucesso")
    void createUserTest() {
        UserRequestCreateDto request = UserRequestCreateDtoFixture.build();
        Departament departament = DepartamentFixture.build();

        when(departamentService.findById(anyLong())).thenReturn(departament);
        when(userRepository.save(any(User.class))).thenAnswer(argument -> argument.getArguments()[0]);
        UserResponseCreateDto response = userService.createUser(request);

//        assertThat(response.getId()).isNotNull();
        assertThat(response.getName()).isEqualTo(request.getName());
        assertThat(response.getEmail()).isEqualTo(request.getEmail());
        assertThat(response.getDepartament()).isNotNull();
        assertThat(response.getDepartament().getId()).isEqualTo(request.getDepartamentId());

        verify(userRepository, times(1)).save(any(User.class));

    }






    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void removeUser() {
    }
}
