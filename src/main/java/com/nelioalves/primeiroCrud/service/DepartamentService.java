package com.nelioalves.primeiroCrud.service;

import com.nelioalves.primeiroCrud.dto.DepartamentDto;
import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.repository.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DepartamentService {

    @Autowired
    private DepartamentRepository departamentRepository;

    public DepartamentDto createDepartament (DepartamentDto departamentDto){
        Departament departamentEntity = new Departament(departamentDto.getId(), departamentDto.getName());
        Departament departamentSaved = departamentRepository.save(departamentEntity);
        return new DepartamentDto(departamentSaved);
    }

    public Departament findById (Long id){
        return departamentRepository.findById(id).get();
    }

    public DepartamentDto findByIdDto(Long id){
        Departament departamentEntity = departamentRepository.findById(id).get();
        return new DepartamentDto(departamentEntity);
    }

     public List<DepartamentDto> findAll(){
        List<Departament> departaments = departamentRepository.findAll();
        List<DepartamentDto> departamentDtos = new ArrayList<>();
        for (Departament departament : departaments ) {
             departamentDtos.add(new DepartamentDto(departament));
        }
        return departamentDtos;
     }
}