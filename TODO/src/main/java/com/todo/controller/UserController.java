package com.todo.controller;

import com.todo.model.User;
import com.todo.service.SignUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.todo.constants.EnumConstants.ResponseStatus;
import com.todo.dto.UserDTO;
import com.todo.model.CustomResponse;
import com.todo.service.UserService;

@Controller
public class UserController {

	final private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@Autowired
	SignUpService signUpService;

	@GetMapping("/test/{value}")
	ResponseEntity<CustomResponse> testApp(@PathVariable String value) {
		LOGGER.info("start");
		CustomResponse customResponse = new CustomResponse("This App is working", ResponseStatus.SUCCESS.getCode(),
				value);
		LOGGER.info("end");
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<CustomResponse> loginUser(@RequestBody UserDTO userDTO) {
		LOGGER.info("start::loginUser");

		CustomResponse customResponse = userService.loginUser(userDTO);

		LOGGER.info("end::loginUser");
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}

	@PostMapping(value="/sign-up",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<CustomResponse> SignupUser(@RequestBody User user){

		LOGGER.info("Signup::Started");

		CustomResponse customResponse=signUpService.SignupUser(user);

		LOGGER.info("Signup::Finished");
		return new ResponseEntity<>(customResponse,HttpStatus.OK);
	}
}
