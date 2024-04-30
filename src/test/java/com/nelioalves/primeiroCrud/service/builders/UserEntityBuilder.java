package com.nelioalves.primeiroCrud.service.builders;

import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.entities.Endereco;
import com.nelioalves.primeiroCrud.entities.User;

public class UserEntityBuilder {

    public static User build(){
        Departament departament = DepartamentEntityBuilder.build();
        Endereco endereco = EnderecoEntityBuilder.build();
        return new User(123456L, "Florisvaldo", "florisvaldo@hotmail.com", departament, endereco);

    }

}
