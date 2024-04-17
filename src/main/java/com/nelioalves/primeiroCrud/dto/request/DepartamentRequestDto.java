package com.nelioalves.primeiroCrud.dto.request;

import com.nelioalves.primeiroCrud.constants.ValidationMessages;
import com.nelioalves.primeiroCrud.entities.Departament;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


//TODO: Adicionar o lombok;
//TODO: Criar Dtos request para update de departamaneto, pois esse DTo é utilzado para create e o id nao pode ser nulo;

public class DepartamentRequestDto {

    //TODO: Implementar validação quando for get por id null ou vazio
    @NotNull(message = ValidationMessages.ID_NOT_NULL)
    private Long id;

    @NotBlank(message = ValidationMessages.NAME_NOT_NULL)
    private String name;

    public DepartamentRequestDto(Departament departament) {
        this.id = departament.getId();
        this.name = departament.getName();
    }

    public DepartamentRequestDto() {
    }

    public DepartamentRequestDto(Long id, String name) {
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
