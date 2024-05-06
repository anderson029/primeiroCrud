package com.nelioalves.primeiroCrud.dto.response;

import com.nelioalves.primeiroCrud.constants.ValidationMessages;
import com.nelioalves.primeiroCrud.dto.request.DepartamentRequestUpdateDto;
import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.entities.Endereco;
import com.nelioalves.primeiroCrud.entities.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Response usuário sucesso")
public class UserResponseCreateDto {
    private Long id;

    private String name;

    private String email;

    private DepartamentResponseDto departament;

    private EnderecoResponseCreateDto endereco;
}