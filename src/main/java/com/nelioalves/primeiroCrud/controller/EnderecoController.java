package com.nelioalves.primeiroCrud.controller;


import com.nelioalves.primeiroCrud.dto.request.EnderecoRequestCreateDto;
import com.nelioalves.primeiroCrud.dto.response.EnderecoResponseCreateDto;
import com.nelioalves.primeiroCrud.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: 1- Implentar crud completo de endereço
// TODO: 2- Finalizar Swagger
@RestController
@RequestMapping(value = "/endereco", produces = {"application/json"})
@AllArgsConstructor
@Tag(name = "Endereço")
public class EnderecoController {

    private EnderecoService enderecoService;

    @Operation(summary = "Cadastro de endereço", description = "Cadastrar endereço de usuário, para poder informar o id no cadastro de usuário", method = "POST")
    @ApiResponse(responseCode = "201", description = "Created")
    @PostMapping
    public ResponseEntity<EnderecoResponseCreateDto> createEndereco(@Valid @RequestBody EnderecoRequestCreateDto endereco){
        EnderecoResponseCreateDto responseEndereco = enderecoService.createEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseEndereco);
    }

    @Operation(summary = "Consultar endereço", method = "GET")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<EnderecoResponseCreateDto>> findAll(){
        List<EnderecoResponseCreateDto> findAll = enderecoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(findAll);
    }

}
