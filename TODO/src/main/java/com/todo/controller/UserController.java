package com.todo.controller;

import com.todo.model.User;
import com.todo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.todo.constants.EnumConstants.ResponseStatus;
import com.todo.model.CustomResponse;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

	final private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@GetMapping("/test/{value}")
	ResponseEntity<CustomResponse> testApp(@PathVariable String value) {
		LOGGER.info("start");
		CustomResponse customResponse = new CustomResponse("This App is working", ResponseStatus.SUCCESS.getCode(),
				value);
		LOGGER.info("end");
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}

	@GetMapping("/getalluser")
	List<User> findByUser() {
		LOGGER.info("start");
		return userService.getllUser();
	}
}
