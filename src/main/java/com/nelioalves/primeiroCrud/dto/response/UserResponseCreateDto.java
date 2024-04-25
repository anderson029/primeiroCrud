package com.nelioalves.primeiroCrud.dto.response;

import com.nelioalves.primeiroCrud.constants.ValidationMessages;
import com.nelioalves.primeiroCrud.dto.request.DepartamentRequestUpdateDto;
import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.entities.User;
import jakarta.validation.constraints.NotBlank;


//TODO: adicionar lombok
public class UserResponseCreateDto {
    private Long id;

    @NotBlank(message = ValidationMessages.NAME_NOT_NULL)
    private String name;

    @NotBlank(message = ValidationMessages.EMAIL_NOT_NULL)
    private String email;

    private DepartamentResponseDto departament;

    public UserResponseCreateDto(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        departament = new DepartamentResponseDto(user.getDepartament().getId(), user.getDepartament().getName());
    }

    public UserResponseCreateDto() {
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

    public DepartamentResponseDto getDepartament() {
        return departament;
    }

    public void setDepartament(DepartamentResponseDto departament) {
        this.departament = departament;
    }
}




