package com.nelioalves.primeiroCrud.controller;


import com.nelioalves.primeiroCrud.dto.DepartamentDto;
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
    public ResponseEntity<DepartamentDto> createDepartament (@RequestBody @Valid DepartamentDto departament){
        DepartamentDto departamentDto = departamentService.createDepartament(departament);
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartamentDto> findById (@PathVariable Long id){
        DepartamentDto departamentDto = departamentService.findByIdDto(id);
        return ResponseEntity.status(HttpStatus.OK).body(departamentDto);
    }

    //TODO: estudar paginação e implementar.
    @GetMapping
    public ResponseEntity <List<DepartamentDto>> findAll(){
        List<DepartamentDto> departamentDtos =  departamentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(departamentDtos);
    }
}
