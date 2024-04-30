package com.nelioalves.primeiroCrud.service;

import com.nelioalves.primeiroCrud.dto.request.DepartamentRequestCreateDto;
import com.nelioalves.primeiroCrud.dto.request.DepartamentRequestUpdateDto;
import com.nelioalves.primeiroCrud.dto.response.DepartamentResponseDto;
import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.repository.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartamentService {
    @Autowired
    private DepartamentRepository departamentRepository;

    public DepartamentResponseDto createDepartament (DepartamentRequestCreateDto departamentDto){
        Departament departamentEntity = Departament.builder()
                .id(null)
                .name(departamentDto.getName())
                .build();
        Departament departamentSaved = departamentRepository.save(departamentEntity);
        return DepartamentResponseDto.builder()
                .id(departamentSaved.getId())
                .name(departamentSaved.getName())
                .build();
    }

    public Departament findById (Long id){
        return departamentRepository.findById(id).get();
    }

    public DepartamentResponseDto findByIdDto(Long id){
        Departament departamentEntity = departamentRepository.findById(id).get();
        return DepartamentResponseDto.builder()
                .id(departamentEntity.getId())
                .name(departamentEntity.getName())
                .build();
    }

    public List<DepartamentResponseDto> findAll(){
        List<Departament> departaments = departamentRepository.findAll();
        List<DepartamentResponseDto> departamentDtos = new ArrayList<>();
        for (Departament departament : departaments ) {
             departamentDtos.add(DepartamentResponseDto.builder()
                     .id(departament.getId())
                     .name(departament.getName())
                     .build());
        }
        return departamentDtos;
     }

     public DepartamentResponseDto updateDepartament(Long id, DepartamentRequestUpdateDto departament) {
        Optional<Departament> departamentOpt = departamentRepository.findById(id);
        if (departamentOpt.isPresent()){
            Departament departamentEntity = departamentOpt.get();
            departamentEntity.setName(departament.getName());
            departamentRepository.save(departamentEntity);
            return DepartamentResponseDto.builder()
                    .id(departamentEntity.getId())
                    .name(departamentEntity.getName())
                    .build();
        }
        else {
            System.out.println("O departamento não foi encontrado"); //TODO: Implementar exceptions.
            return null;
        }
     }

    public void deleteDepartament(Long id) {
        Optional<Departament> departamentOpt = departamentRepository.findById(id);
        if (departamentOpt.isPresent()){
            departamentRepository.deleteById(id);
        }
        else{
            System.out.print("Departamento não encontrado"); //TODO: Implementar exceptions.
        }
    }
}