package com.nelioalves.primeiroCrud.dto.response;


import com.nelioalves.primeiroCrud.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //porque sem o data nao retorna os dados?
@AllArgsConstructor
@NoArgsConstructor
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

    public EnderecoResponseCreateDto(Endereco endereco){
        this.Id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.cep = endereco.getCep();
        this.pais = endereco.getPais();
    }
}
