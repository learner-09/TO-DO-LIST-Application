package com.todo.service.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.todo.constants.EnumConstants.ResponseStatus;
import com.todo.dto.UserDTO;
import com.todo.jwt.JwtTokenUtil;
import com.todo.jwt.JwtUser;
import com.todo.jwt.JwtUserDetailsService;
import com.todo.model.CustomResponse;
import com.todo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUserDetailsService jwtUserDetailService;

	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@Override
	public CustomResponse loginUser(UserDTO userDTO) {
		LOGGER.info("start::loginUser");
		CustomResponse customResponse = null;
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUserName(),
					String.copyValueOf(userDTO.getPassword())));
		} catch (BadCredentialsException badCredentialsException) {
			LOGGER.error("User credentials not valid");
			return new CustomResponse("Invalid credentials", null, ResponseStatus.FAILURE.getCode());
		}

		customResponse = new CustomResponse("Login Successful", generateTokenGetUser(userDTO.getUserName()),
				ResponseStatus.SUCCESS.getCode());

		LOGGER.info("end::loginUser");
		return customResponse;
	}

	private Map<String, String> generateTokenGetUser(String userName) {
		JwtUser jwtUser = (JwtUser) jwtUserDetailService.loadUserByUsername(userName);

		String token = jwtTokenUtil.generateToken(jwtUser);

		Map<String, String> resp = new HashMap<>();

		resp.put("userName", jwtUser.getUser().getUserName());
		resp.put("contact", jwtUser.getUser().getContact());
		resp.put("email", jwtUser.getUser().getEmail());
		resp.put("name", jwtUser.getUser().getName());
		resp.put("id", String.valueOf(jwtUser.getUser().getId()));
		resp.put("token", token);

		return resp;
	}

}
