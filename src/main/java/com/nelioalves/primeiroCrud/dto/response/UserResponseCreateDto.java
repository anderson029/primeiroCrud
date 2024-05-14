package com.nelioalves.primeiroCrud.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseCreateDto {
    private Long id;

    private String name;

    private String email;

    private DepartamentResponseDto departament;

    private EnderecoResponseCreateDto endereco;
}