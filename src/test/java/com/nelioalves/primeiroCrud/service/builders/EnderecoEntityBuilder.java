package com.nelioalves.primeiroCrud.service.builders;

import com.nelioalves.primeiroCrud.entities.Endereco;

public class EnderecoEntityBuilder {

    public static Endereco build() {
        return Endereco.builder()
                .Id(12L)
                .rua("Rua")
                .numero(1)
                .complemento("casa")
                .bairro("Bairro test")
                .cidade("Cidade")
                .estado("SP")
                .cep("09350-450")
                .pais("Brasil")
                .build();
    }
}
