package com.todo.controller;

import com.todo.exceptions.TaskNotFound;
import com.todo.exceptions.UserNotFound;
import com.todo.model.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHandlController {

    @ExceptionHandler(UserNotFound.class)
    public CustomResponse handleUserNotFound(){
        return new CustomResponse("User does not found","Failed", HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    @ExceptionHandler(TaskNotFound.class)
    public CustomResponse handleTaskNotFound(){
        return new CustomResponse("Task does not found","Failed", HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    @ExceptionHandler(SQLException.class)
    public CustomResponse handleSqlException(){
        return new CustomResponse("Wrong Sql Query","Failed", HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
    }
}
