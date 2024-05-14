package com.nelioalves.primeiroCrud.dto.request;

import com.nelioalves.primeiroCrud.constants.ValidationMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO: adicionar regras nas request, como exemplo do email.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestCreateDto {

    @NotBlank(message = ValidationMessages.NAME_NOT_NULL)
    private String name;

    @NotBlank(message = ValidationMessages.EMAIL_NOT_NULL)
    @Email
    private String email;

    @NotNull(message = ValidationMessages.ID_DEPARTAMENT_NOT_NULL)
    private Long departamentId;

    @NotNull(message = ValidationMessages.ID_ENDERECO_NOT_NULL)
    private Long enderecoId;
}