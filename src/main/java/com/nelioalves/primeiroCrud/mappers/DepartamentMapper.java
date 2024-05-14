package com.nelioalves.primeiroCrud.mappers;

import com.nelioalves.primeiroCrud.dto.response.DepartamentResponseDto;
import com.nelioalves.primeiroCrud.entities.Departament;

public class DepartamentMapper {
     public static DepartamentResponseDto toDepartamentResponseDto(Departament departament) {
         return DepartamentResponseDto.builder()
                 .id(departament.getId())
                 .name(departament.getName())
                 .build();
     }
}
