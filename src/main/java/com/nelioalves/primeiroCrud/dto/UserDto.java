package com.nelioalves.primeiroCrud.dto;

import com.nelioalves.primeiroCrud.constants.ValidationMessages;
import com.nelioalves.primeiroCrud.dto.request.DepartamentRequestUpdateDto;
import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.entities.User;
import jakarta.validation.constraints.NotBlank;

//TODO: adicionar regras nas request, como exemplo do email.
public class UserDto {
    private Long id;

    @NotBlank(message = ValidationMessages.NAME_NOT_NULL)
    private String name;

    @NotBlank(message = ValidationMessages.EMAIL_NOT_NULL)
    private String email;

    private DepartamentRequestUpdateDto departament;

    public UserDto(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        departament = new DepartamentRequestUpdateDto(user.getDepartament().getId(), user.getDepartament().getName());
    }

    public UserDto() {
    }

    public UserDto(Long id, String name, String email, Departament departament) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departament = new DepartamentRequestUpdateDto(departament.getId(), departament.getName());
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

    public DepartamentRequestUpdateDto getDepartament() {
        return departament;
    }

    public void setDepartament(DepartamentRequestUpdateDto departament) {
        this.departament = departament;
    }
}
