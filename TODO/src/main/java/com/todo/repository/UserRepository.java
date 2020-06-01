package com.todo.repository;

import org.springframework.data.repository.CrudRepository;

import com.todo.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String userName);
    User save(User user);
}