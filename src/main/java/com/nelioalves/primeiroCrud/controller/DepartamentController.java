package com.nelioalves.primeiroCrud.controller;


import com.nelioalves.primeiroCrud.dto.request.DepartamentRequestCreateDto;
import com.nelioalves.primeiroCrud.dto.request.DepartamentRequestUpdateDto;
import com.nelioalves.primeiroCrud.dto.response.DepartamentResponseDto;
import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.mappers.DepartamentMapper;
import com.nelioalves.primeiroCrud.service.DepartamentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: Atualizar Swagger após criar exceptions;
//TODO: Criar parâmetros para os métodos GET.
@RestController
@RequestMapping(value = "/departaments", produces = {"application/json"})
@AllArgsConstructor
@Tag(name = "Departament")
public class DepartamentController {

    private DepartamentService departamentService;

    @Operation(summary = "Cadastro de departamento", description = "Cadastrar departamento para informar o id no cadastro de usuário", method = "POST")
    @ApiResponse(responseCode = "201", description = "Created")
    @PostMapping
    public ResponseEntity<DepartamentResponseDto> createDepartament (@RequestBody @Valid DepartamentRequestCreateDto departament){
        DepartamentResponseDto departamentDto = departamentService.createDepartament(departament);
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentDto);
    }

    @Operation(summary = "Consultar departamento", description = "Consultar departamento por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(deprecated = false)))
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartamentResponseDto> findById (@PathVariable Long id){
        Departament departament = departamentService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(DepartamentMapper.toDepartamentResponseDto(departament));
    }

    @Operation(summary = "Lista de departamentos", description = "Listar departamentos", method = "GET")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity <List<DepartamentResponseDto>> findAll(){
        List<DepartamentResponseDto> departamentDtos =  departamentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(departamentDtos);
    }

    @Operation(summary = "Atualizar departamento", method = "PUT")
    @ApiResponse(responseCode = "200", description = "OK")
    @PutMapping(value = "/{id}")
    public ResponseEntity<DepartamentResponseDto> updateDepartament (@PathVariable Long id, @RequestBody @Valid DepartamentRequestUpdateDto departament){
        DepartamentResponseDto departamentDTO = departamentService.updateDepartament(id, departament);
        return ResponseEntity.status(HttpStatus.OK).body(departamentDTO);
    }

    @Operation(summary = "Cadastro de departamento", description = "Cadastrar departamento para informar o id no cadastro de usuário", method = "POST")
    @ApiResponse(responseCode = "204", description = "No Content")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteDepartament(@PathVariable Long id){
        departamentService.deleteDepartament(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
