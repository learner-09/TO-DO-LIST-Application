package com.todo.service;

import com.todo.model.CustomResponse;
import com.todo.model.Task;

public interface TaskService {

	CustomResponse deleteTask(Integer id);
	CustomResponse addTask(Task task);
	CustomResponse fetchTaskByUsera();
}
