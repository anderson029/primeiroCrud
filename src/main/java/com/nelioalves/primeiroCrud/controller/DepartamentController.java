package com.nelioalves.primeiroCrud.controller;


import com.nelioalves.primeiroCrud.dto.request.DepartamentRequestCreateDto;
import com.nelioalves.primeiroCrud.dto.request.DepartamentRequestUpdateDto;
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
    public ResponseEntity<DepartamentResponseDto> createDepartament (@RequestBody @Valid DepartamentRequestCreateDto departament){
        DepartamentResponseDto departamentDto = departamentService.createDepartament(departament);
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartamentResponseDto> findById (@PathVariable Long id){
        DepartamentResponseDto departamentDto = departamentService.findByIdDto(id);
        return ResponseEntity.status(HttpStatus.OK).body(departamentDto);
    }

    //TODO: estudar paginação e implementar.
    @GetMapping
    public ResponseEntity <List<DepartamentResponseDto>> findAll(){
        List<DepartamentResponseDto> departamentDtos =  departamentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(departamentDtos);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DepartamentResponseDto> updateDepartament (@PathVariable Long id, @RequestBody @Valid DepartamentRequestUpdateDto departament){
        DepartamentResponseDto departamentDTO = departamentService.updateDepartament(id, departament);
        return ResponseEntity.status(HttpStatus.OK).body(departamentDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteDepartament(@PathVariable Long id){
        departamentService.deleteDepartament(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
