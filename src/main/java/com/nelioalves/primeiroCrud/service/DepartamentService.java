package com.nelioalves.primeiroCrud.service;


import com.nelioalves.primeiroCrud.entities.Departament;
import com.nelioalves.primeiroCrud.repository.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentService {

    @Autowired
    private DepartamentRepository departamentRepository;

    public Departament findById (Long id){
        return departamentRepository.findById(id).get();
    }
}
