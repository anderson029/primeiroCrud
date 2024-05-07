package com.nelioalves.primeiroCrud.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequestQueryDto {

    private String name;

    private String email;

}
