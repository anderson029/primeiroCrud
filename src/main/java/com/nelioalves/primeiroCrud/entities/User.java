package com.nelioalves.primeiroCrud.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity // anotação da JPA
@Table(name = "tb_user") // anotação da JPA para nomear a tabela
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id // para dizer que minha chave é primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para o id ser auto incrementado pelo banco de dados
    private Long id;
    private String name;

    private String email;

    @ManyToOne // tag JPA que relaciona que muitos usuário podem ser cadastrados em um único departamento.
    @JoinColumn(name = "department_id") // configurando o nome da chave estrangeira do banco de dados departamento na classe uduário
    private Departament departament; // em java estou "ligando" os objetos, porém tenho que fazer o mesmo no banco relacional

}
