package com.nelioalves.primeiroCrud.service.fixtures;

import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.entities.User;

public class UserEntityFixture {

    public static User build(){
        Departament departament = DepartamentFixture.build();
        return new User(123456L, "Florisvaldo", "florisvaldo@hotmail.com", departament);
    }

}
