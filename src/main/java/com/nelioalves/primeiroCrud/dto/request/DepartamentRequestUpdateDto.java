package com.nelioalves.primeiroCrud.dto.request;

import com.nelioalves.primeiroCrud.constants.ValidationMessages;
import com.nelioalves.primeiroCrud.entities.Departament;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


//TODO: Adicionar o lombok;
//TODO: Criar Dtos request para update de departamaneto, pois esse DTo é utilizado para create e o id nao pode ser nulo;

public class DepartamentRequestUpdateDto {

    @NotBlank(message = ValidationMessages.NAME_NOT_NULL)
    private String name;

    public DepartamentRequestUpdateDto(Departament departament) {
        this.name = departament.getName();
    }

    public DepartamentRequestUpdateDto() {
    }

    public DepartamentRequestUpdateDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
