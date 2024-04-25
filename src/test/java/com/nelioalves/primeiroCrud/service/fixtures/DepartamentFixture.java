package com.nelioalves.primeiroCrud.service.fixtures;

import com.nelioalves.primeiroCrud.entities.Departament;

public class DepartamentFixture {

    public static Departament build(){
        return new Departament(1234L, "Gestão");
    }
}
