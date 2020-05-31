package com.todo.services;

import com.todo.model.User;
import com.todo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getllUser(){
        return userRepo.findAll();
    }
}
