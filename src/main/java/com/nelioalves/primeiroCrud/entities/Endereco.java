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
//Todo alterar nomenclatura da classe para address e Entity
//Todo adicionar data e hora da criação do dados e update
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String rua;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    @Column(length = 3)
    private String pais;
}
