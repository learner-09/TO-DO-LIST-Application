package com.todo.service.serviceImpl;

import com.todo.constants.EnumConstants.ResponseStatus;
import com.todo.model.CustomResponse;
import com.todo.model.User;
import com.todo.repository.UserRepository;
import com.todo.service.SignUpService;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

	private final static Logger LOGGER = LoggerFactory.getLogger(SignUpService.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public CustomResponse SignupUser(User user) {
		LOGGER.info("Inside::SignupUser" + user);

		if (user == null) {
			LOGGER.info("User is null and Returning Failed from Signup");

			return new CustomResponse("Failed Signed-Up", null, ResponseStatus.FAILURE.getCode());
		}

		user.setCreatedDate(new Date().toString());

		LOGGER.info("Encrypting password started");

		String rawPassword = user.getPassword();
		user.setPassword(passwordEncoder(rawPassword));

		LOGGER.info("Encrypting password done");

		User returnedUser = userRepository.save(user);
		LOGGER.info("After executing save method");

		if (user.equals(returnedUser)) {
			LOGGER.info("Returning Success from Signup");

			return new CustomResponse("SuccessFully Signed-Up", null, ResponseStatus.SUCCESS.getCode());
		} else {

			LOGGER.info("Returning Failed from Signup");

			return new CustomResponse("Failed Signed-Up", null, ResponseStatus.FAILURE.getCode());
		}
	}

	public static String passwordEncoder(String password) {
		LOGGER.info("Inside::passwordEncoder");
		return new BCryptPasswordEncoder().encode(password);
	}
}
