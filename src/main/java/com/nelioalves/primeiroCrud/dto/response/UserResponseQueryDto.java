package com.nelioalves.primeiroCrud.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseQueryDto {

    private Long id;

    private String name;

    private String email;

    private DepartamentResponseDto departament;

    private EnderecoResponseCreateDto endereco;
}
