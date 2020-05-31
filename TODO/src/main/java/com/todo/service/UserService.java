package com.todo.service;

import com.todo.dto.UserDTO;
import com.todo.model.CustomResponse;

public interface UserService {

	CustomResponse loginUser(UserDTO userDTO);

}
