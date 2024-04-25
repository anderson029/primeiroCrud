package com.nelioalves.primeiroCrud.dto.request;

import com.nelioalves.primeiroCrud.constants.ValidationMessages;
import jakarta.validation.constraints.NotNull;

public class DepartamentRequestCreateDto {

    @NotNull(message = ValidationMessages.NAME_NOT_NULL)
    private String name;

    public DepartamentRequestCreateDto() {
    }
    public DepartamentRequestCreateDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
