package com.todo.service.serviceImpl;

import com.todo.constants.EnumConstants.ResponseStatus;
import com.todo.model.CustomResponse;
import com.todo.model.User;
import com.todo.repository.UserRepository;
import com.todo.service.SignUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SignUpServiceImpl implements SignUpService {

    private final Logger LOGGER = LoggerFactory.getLogger(SignUpService.class);

    @Autowired
    UserRepository userRepository;
    @Override
    public CustomResponse SignupUser(User user) {
        LOGGER.info("Inside::SignupUser");

        User returnedUser=userRepository.save(user);
        LOGGER.info("After executing save method");

        if(user.equals(returnedUser)){
            LOGGER.info("Returning Success from Signup");

            return new CustomResponse("SuccessFully Signed-Up",null, ResponseStatus.SUCCESS.getCode());
        }else{

            LOGGER.info("Returning Failed from Signup");

            return new CustomResponse("Failed Signed-Up",null, ResponseStatus.FAILURE.getCode());
        }
    }
}
