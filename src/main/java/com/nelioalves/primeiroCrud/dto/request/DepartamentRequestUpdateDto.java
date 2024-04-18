package com.nelioalves.primeiroCrud.dto.request;

import com.nelioalves.primeiroCrud.constants.ValidationMessages;
import com.nelioalves.primeiroCrud.entities.Departament;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


//TODO: Adicionar o lombok;
//TODO: Criar Dtos request para update de departamaneto, pois esse DTo é utilizado para create e o id nao pode ser nulo;

public class DepartamentRequestUpdateDto {

    private Long id;

    @NotBlank(message = ValidationMessages.NAME_NOT_NULL)
    private String name;

    public DepartamentRequestUpdateDto(Departament departament) {
        this.id = departament.getId();
        this.name = departament.getName();
    }

    public DepartamentRequestUpdateDto() {
    }

    public DepartamentRequestUpdateDto(Long id, String name) {
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
