package com.todo.exceptions;

import com.todo.model.CustomResponse;

public class UserNotFound extends RuntimeException{
    private CustomResponse customResponse;

    public UserNotFound(CustomResponse customResponse) {
        this.customResponse = customResponse;
    }

    public CustomResponse getCustomResponse() {
        return customResponse;
    }

    public void setCustomResponse(CustomResponse customResponse) {
        this.customResponse = customResponse;
    }
}
