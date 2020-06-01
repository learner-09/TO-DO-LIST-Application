package com.todo.service;

import com.todo.dto.UserDTO;
import com.todo.model.CustomResponse;
import com.todo.model.User;

public interface UserService {

	CustomResponse loginUser(UserDTO userDTO);

}
