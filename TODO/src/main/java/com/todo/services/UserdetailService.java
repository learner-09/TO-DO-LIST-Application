package com.todo.services;

import com.todo.controller.UserController;
import com.todo.model.User;
import com.todo.model.Userdetails;
import com.todo.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserdetailService implements UserDetailsService {

    final private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        LOGGER.info("inside userdetailsservice"+" "+userName);
        Optional<User> user=userRepo.findByusername(userName);

        LOGGER.info("inside userdetailsservice"+user.get().getUsername());

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(Userdetails::new).get();
    }
}