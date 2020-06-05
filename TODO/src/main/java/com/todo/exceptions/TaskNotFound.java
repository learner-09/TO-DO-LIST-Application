package com.todo.exceptions;

import com.todo.model.CustomResponse;

public class TaskNotFound extends RuntimeException{
    private CustomResponse customResponse;

    public TaskNotFound(CustomResponse customResponse) {
        this.customResponse = customResponse;
    }

    public CustomResponse getCustomResponse() {
        return customResponse;
    }

    public void setCustomResponse(CustomResponse customResponse) {
        this.customResponse = customResponse;
    }
}
