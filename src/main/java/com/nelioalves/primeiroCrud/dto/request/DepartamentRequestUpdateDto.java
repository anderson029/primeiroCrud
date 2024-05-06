package com.nelioalves.primeiroCrud.dto.request;

import com.nelioalves.primeiroCrud.constants.ValidationMessages;
import com.nelioalves.primeiroCrud.entities.Departament;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Atualização de departamento")
public class DepartamentRequestUpdateDto {

    @NotBlank(message = ValidationMessages.NAME_NOT_NULL)
    private String name;

}
