package com.psoft.project.services;

import com.psoft.project.model.User;
import com.psoft.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(int id){
        return repository.findById(id);
    }

    public User findByName(String name){
        return  repository.findByName(name);
    }
}
