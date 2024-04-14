package com.nelioalves.primeiroCrud.repository;

import com.nelioalves.primeiroCrud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
