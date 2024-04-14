package com.nelioalves.primeiroCrud.dto;

import com.nelioalves.primeiroCrud.entities.Departament;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String email;
    private Departament departament;
}
