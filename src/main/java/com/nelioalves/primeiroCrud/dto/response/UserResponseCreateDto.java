package com.nelioalves.primeiroCrud.dto.response;

import com.nelioalves.primeiroCrud.constants.ValidationMessages;
import com.nelioalves.primeiroCrud.dto.request.DepartamentRequestUpdateDto;
import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.entities.Endereco;
import com.nelioalves.primeiroCrud.entities.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseCreateDto {
    private Long id;

    private String name;

    private String email;

    private DepartamentResponseDto departament;

    private EnderecoResponseCreateDto endereco;

    public UserResponseCreateDto(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        departament = new DepartamentResponseDto(user.getDepartament());
        endereco = new EnderecoResponseCreateDto(user.getEndereco());
    }
}