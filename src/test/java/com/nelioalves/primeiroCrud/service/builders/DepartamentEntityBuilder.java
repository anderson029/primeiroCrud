package com.nelioalves.primeiroCrud.service.builders;

import com.nelioalves.primeiroCrud.entities.Departament;

public class DepartamentEntityBuilder {

    public static Departament build(){
        return Departament.builder()
                .id(1234L)
                .name("Gestão")
                .build();
    }
}
