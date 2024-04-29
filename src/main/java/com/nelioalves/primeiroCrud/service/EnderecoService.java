package com.nelioalves.primeiroCrud.service;

import com.nelioalves.primeiroCrud.dto.request.EnderecoRequestCreateDto;
import com.nelioalves.primeiroCrud.dto.response.EnderecoResponseCreateDto;
import com.nelioalves.primeiroCrud.entities.Endereco;
import com.nelioalves.primeiroCrud.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        return EnderecoResponseCreateDto.builder()
                .Id(enderecoBanco.getId())
                .rua(enderecoBanco.getRua())
                .numero(enderecoBanco.getNumero())
                .complemento(enderecoBanco.getComplemento())
                .bairro(enderecoBanco.getBairro())
                .cidade(enderecoBanco.getCidade())
                .estado(enderecoBanco.getEstado())
                .cep(enderecoBanco.getCep())
                .pais(enderecoBanco.getPais())
                .build();
    }

    public Endereco findById (Long id){
        Optional<Endereco> end = enderecoRepository.findById(id);
        Endereco endereco = end.isPresent() ? end.get() : null;
        return endereco;
    }

    public List<EnderecoResponseCreateDto> findAll(){
        List<Endereco> listComplete = enderecoRepository.findAll();
        List<EnderecoResponseCreateDto> enderecoList = new ArrayList<>();

        for (Endereco end : listComplete){
            enderecoList.add(EnderecoResponseCreateDto.builder()
                            .Id(end.getId())
                            .rua(end.getRua())
                            .numero(end.getNumero())
                            .complemento(end.getComplemento())
                            .bairro(end.getBairro())
                            .cidade(end.getCidade())
                            .estado(end.getEstado())
                            .cep(end.getCep())
                            .pais(end.getPais())
                            .build());
        }
        return enderecoList;
    }
}
