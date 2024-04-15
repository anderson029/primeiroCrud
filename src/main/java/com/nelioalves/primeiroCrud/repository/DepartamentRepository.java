package com.nelioalves.primeiroCrud.repository;

import com.nelioalves.primeiroCrud.entities.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentRepository extends JpaRepository<Departament, Long> {
}
