package com.nelioalves.primeiroCrud.service.builders.Dtos;

import com.nelioalves.primeiroCrud.dto.request.UserRequestCreateDto;

public class UserRequestCreateDtoFixture {
     public static UserRequestCreateDto build(){
         return new UserRequestCreateDto("Florisvaldo", "florisvaldo@hotmail.com",1234L, 1L);
     }
}
