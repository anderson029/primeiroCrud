package com.nelioalves.primeiroCrud.repository;

import com.nelioalves.primeiroCrud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//TODO estudar SQL
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
    List<User> findByEmail(String email);
    List<User> findByNameOrEmail(String name, String email);
}
