package com.nelioalves.primeiroCrud.dto.request;

import com.nelioalves.primeiroCrud.constants.ValidationMessages;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Cadastro de departamento")
public class DepartamentRequestCreateDto {

    @NotNull(message = ValidationMessages.NAME_NOT_NULL)
    private String name;
}