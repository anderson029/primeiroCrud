package com.nelioalves.primeiroCrud.dto;

import com.nelioalves.primeiroCrud.entities.Departament;

public class DepartamentDto {
     private Long id;

     private String name;

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
