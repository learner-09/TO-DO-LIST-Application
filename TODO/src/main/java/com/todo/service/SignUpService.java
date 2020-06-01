package com.todo.service;

import com.todo.model.CustomResponse;
import com.todo.model.User;

public interface SignUpService {
    CustomResponse SignupUser(User user);
}
