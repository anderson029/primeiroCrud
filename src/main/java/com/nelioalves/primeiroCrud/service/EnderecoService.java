package com.nelioalves.primeiroCrud.service;

import com.nelioalves.primeiroCrud.dto.request.EnderecoRequestCreateDto;
import com.nelioalves.primeiroCrud.dto.response.EnderecoResponseCreateDto;
import com.nelioalves.primeiroCrud.entities.Endereco;
import com.nelioalves.primeiroCrud.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoResponseCreateDto createEndereco(EnderecoRequestCreateDto endereco){
        Endereco enderecoEntity = Endereco.builder()
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .pais(endereco.getPais())
                .build();

        Endereco enderecoBanco = enderecoRepository.save(enderecoEntity);
        return new EnderecoResponseCreateDto(enderecoBanco); //TODO Giva seria legal usar builder no response, ou criar contrutor como fiz?

    }

    public Endereco findById (Long id){
        Optional<Endereco> end = enderecoRepository.findById(id);
        Endereco endereco = end.isPresent() ? end.get() : null;
        return endereco;
    }
}
