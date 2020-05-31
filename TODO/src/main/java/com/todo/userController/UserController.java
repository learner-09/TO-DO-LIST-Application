package com.todo.userController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.todo.constants.EnumConstants.ResponseStatus;
import com.todo.jwt.JwtTokenUtil;
import com.todo.jwt.JwtUser;
import com.todo.jwt.JwtUserDetailsService;
import com.todo.model.CustomResponse;
import com.todo.model.User;

@Controller
public class UserController {

	final private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailService;

	@GetMapping("/test/{value}")
	ResponseEntity<CustomResponse> testApp(@PathVariable String value) {
		LOGGER.info("start");
		CustomResponse customResponse = new CustomResponse("This App is working", ResponseStatus.SUCCESS.getCode(),
				value);
		LOGGER.info("end");
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}

	@GetMapping("/login")
	ResponseEntity<CustomResponse> testApp() {
		LOGGER.info("start");
		User user = new User();
		user.setName("shardul");
		user.setUserName("one");
		user.setContact("7753016769");

		JwtUser jwtUser = new JwtUser();
		jwtUser.setUser(user);

		String token = jwtTokenUtil.generateToken(jwtUser);
		
		jwtUserDetailService.loadUserByUsername("someUserName");

		CustomResponse customResponse = new CustomResponse("This App is working", ResponseStatus.SUCCESS.getCode(),
				token);
		LOGGER.info("end");
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}
}
