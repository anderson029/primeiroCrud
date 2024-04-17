package com.nelioalves.primeiroCrud.controller;


import com.nelioalves.primeiroCrud.dto.request.DepartamentRequestDto;
import com.nelioalves.primeiroCrud.dto.response.DepartamentResponseDto;
import com.nelioalves.primeiroCrud.service.DepartamentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: Criar Swagger.
//TODO: Criar parâmetros para os métodos GET.
@RestController
@RequestMapping(value = "/departaments")
public class DepartamentController {

    @Autowired
    private DepartamentService departamentService;
    @PostMapping
    public ResponseEntity<DepartamentResponseDto> createDepartament (@RequestBody @Valid DepartamentRequestDto departament){
        DepartamentResponseDto departamentDto = departamentService.createDepartament(departament);
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartamentResponseDto> findById (@PathVariable Long id){
        DepartamentResponseDto departamentDto = departamentService.findByIdDto(id);
        return ResponseEntity.status(HttpStatus.OK).body(departamentDto);
    }

    //TODO: estudar paginação e implementar.
    //TODO:
    @GetMapping
    public ResponseEntity <List<DepartamentResponseDto>> findAll(){
        List<DepartamentResponseDto> departamentDtos =  departamentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(departamentDtos);
    }

    //TODO: Receber Id como variavel na URL
    @PutMapping
    public ResponseEntity updateDepartament (@RequestBody DepartamentRequestDto departament){
        departamentService.updateDepartament(departament);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteDepartament(@PathVariable Long id){
        departamentService.deleteDepartament(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
