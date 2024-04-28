package com.nelioalves.primeiroCrud.service.fixtures;

import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.entities.Endereco;
import com.nelioalves.primeiroCrud.entities.User;

public class UserEntityFixture {

    public static User build(){
        Departament departament = DepartamentFixture.build();
        return new User(123456L, "Florisvaldo", "florisvaldo@hotmail.com", departament, Endereco.builder()
                .rua("teste rua")
                .numero(12345)
                .complemento("AP45")
                .bairro("Teste bairro")
                .cidade("teste Cidade")
                .estado("testes estado")
                .cep("teste cep")
                .pais("Brasil")
                .build());
    }

}
