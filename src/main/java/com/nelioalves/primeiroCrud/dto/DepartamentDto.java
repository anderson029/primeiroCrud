package com.nelioalves.primeiroCrud.dto;

import com.nelioalves.primeiroCrud.constants.ValidationMessages;
import com.nelioalves.primeiroCrud.entities.Departament;
import jakarta.validation.constraints.NotBlank;


//TODO: Adicionar após o lombok;
//TODO: DTOS de response e request para implementar validação somente nas request;

public class DepartamentDto {
     private Long id;

     @NotBlank(message = ValidationMessages.NAME_NOT_NULL)
     private String name;

    public DepartamentDto(Departament departament) {
        this.id = departament.getId();
        this.name = departament.getName();
    }

    public DepartamentDto() {
    }

    public DepartamentDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
