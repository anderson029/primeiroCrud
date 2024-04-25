package com.nelioalves.primeiroCrud.dto.request;

import com.nelioalves.primeiroCrud.constants.ValidationMessages;
import com.nelioalves.primeiroCrud.dto.request.DepartamentRequestUpdateDto;
import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.entities.User;
import jakarta.validation.constraints.NotBlank;

//TODO: adicionar regras nas request, como exemplo do email.
public class UserRequestCreateDto {

    @NotBlank(message = ValidationMessages.NAME_NOT_NULL)
    private String name;

    @NotBlank(message = ValidationMessages.EMAIL_NOT_NULL)
    private String email;

    private Long departamentId;

    public String getName() {
        return name;
    }

    public UserRequestCreateDto(String name, String email, Long departamentId) {
        this.name = name;
        this.email = email;
        this.departamentId = departamentId;
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

    public Long getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(Long departamentId) {
        this.departamentId = departamentId;
    }
}
