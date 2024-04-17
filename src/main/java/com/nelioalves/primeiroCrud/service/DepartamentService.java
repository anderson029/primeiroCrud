package com.nelioalves.primeiroCrud.service;

import com.nelioalves.primeiroCrud.dto.request.DepartamentRequestDto;
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

    //TODO: Sugeriu fazer um ATOMIC
    public DepartamentResponseDto createDepartament (DepartamentRequestDto departamentDto){
        Departament departamentEntity = new Departament(departamentDto.getId(), departamentDto.getName());
        Departament departamentSaved = departamentRepository.save(departamentEntity);
        return new DepartamentResponseDto(departamentSaved);
    }

    public Departament findById (Long id){
        return departamentRepository.findById(id).get();
    }

    public DepartamentResponseDto findByIdDto(Long id){
        Departament departamentEntity = departamentRepository.findById(id).get();
        return new DepartamentResponseDto(departamentEntity);
    }

    public List<DepartamentResponseDto> findAll(){
        List<Departament> departaments = departamentRepository.findAll();
        List<DepartamentResponseDto> departamentDtos = new ArrayList<>();
        for (Departament departament : departaments ) {
             departamentDtos.add(new DepartamentResponseDto(departament));
        }
        return departamentDtos;
     }

     public void updateDepartament(DepartamentRequestDto departament) {
        Optional<Departament> departamentOpt = departamentRepository.findById(departament.getId());
        if (departamentOpt.isPresent()){
            Departament departamentEntity = departamentOpt.get();
            departamentEntity.setName(departament.getName());
            departamentRepository.save(departamentEntity);
        }
        else {
            System.out.println("O departamento não foi encontrado"); //TODO: Implementar exceptions.
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