package com.nelioalves.primeiroCrud.controller;


import com.nelioalves.primeiroCrud.dto.request.EnderecoRequestCreateDto;
import com.nelioalves.primeiroCrud.dto.response.EnderecoResponseCreateDto;
import com.nelioalves.primeiroCrud.service.EnderecoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: implentar crud completo de endereço
@RestController
@RequestMapping(value = "/endereco")
@AllArgsConstructor
public class EnderecoController {

    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoResponseCreateDto> createEndereco(@Valid @RequestBody EnderecoRequestCreateDto endereco){
        EnderecoResponseCreateDto responseEndereco = enderecoService.createEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseEndereco);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseCreateDto>> findAll(){
        List<EnderecoResponseCreateDto> findAll = enderecoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(findAll);
    }

}
