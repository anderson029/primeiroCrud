package com.nelioalves.primeiroCrud.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tb_endereco")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
//Todo alterar nomenclatura da classe para address
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep; //TODO alterar cep para inteiro;
    private String pais;
}
