package com.nelioalves.primeiroCrud.dto;

import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.entities.User;

public class UserDto {
    private Long id;

    private String name;

    private String email;

    private DepartamentDto departament;

    public UserDto(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        departament = new DepartamentDto(user.getDepartament().getId(), user.getDepartament().getName());
    }

    public UserDto() {
    }

    public UserDto(Long id, String name, String email, Departament departament) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departament = new DepartamentDto(departament.getId(), departament.getName());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DepartamentDto getDepartament() {
        return departament;
    }

    public void setDepartament(DepartamentDto departament) {
        this.departament = departament;
    }
}
