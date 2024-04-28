package com.nelioalves.primeiroCrud.dto.response;

import com.nelioalves.primeiroCrud.entities.Departament;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentResponseDto {
    private Long id;
    private String name;

    public DepartamentResponseDto(Departament departament) {
        this.id = departament.getId();
        this.name = departament.getName();
    }
}
