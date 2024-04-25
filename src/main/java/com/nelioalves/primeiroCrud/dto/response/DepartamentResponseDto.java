package com.nelioalves.primeiroCrud.dto.response;

import com.nelioalves.primeiroCrud.entities.Departament;

public class DepartamentResponseDto {
    private Long id;
    private String name;

    public DepartamentResponseDto() {
    }

    public DepartamentResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartamentResponseDto(Departament departament) {
        this.id = departament.getId();
        this.name = departament.getName();
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
