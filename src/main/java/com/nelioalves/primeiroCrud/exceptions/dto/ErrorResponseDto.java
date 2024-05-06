package com.nelioalves.primeiroCrud.exceptions.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Error Response")
public class ErrorResponseDto {
    private String code;

    private String message;
}
