package com.nelioalves.primeiroCrud.dto.response;


import com.nelioalves.primeiroCrud.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //porque sem o data nao retorna os dados?
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoResponseCreateDto {
    private Long Id;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;
}
