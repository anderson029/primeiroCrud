package com.nelioalves.primeiroCrud.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Response departamento sucesso")
public class DepartamentResponseDto {
    private Long id;
    private String name;
}