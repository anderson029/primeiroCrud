package com.nelioalves.primeiroCrud.service;

import com.nelioalves.primeiroCrud.entities.User;
import com.nelioalves.primeiroCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser {
    @Autowired //importar automaticamente minha interface
    private UserRepository repository;

    public User salvarUser(user) {
        User result = repository.save(user);
        return result;
    }
}
