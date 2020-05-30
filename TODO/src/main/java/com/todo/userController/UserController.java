package com.todo.userController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.todo.constants.EnumConstants.ResponseStatus;
import com.todo.model.CustomResponse;

@Controller
public class UserController {

	final private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/test/{value}")
	ResponseEntity<CustomResponse> testApp(@PathVariable String value) {
		LOGGER.info("start");
		CustomResponse customResponse = new CustomResponse("This App is working", ResponseStatus.SUCCESS.getCode(),
				value);
		LOGGER.info("end");
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}
}
