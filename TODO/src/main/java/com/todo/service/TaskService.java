package com.todo.service;

import com.todo.dto.SearchTaskDTO;
import com.todo.dto.TaskDto;
import com.todo.model.CustomResponse;
import com.todo.model.Task;

public interface TaskService {

	CustomResponse deleteTask(Integer id);

	CustomResponse addTask(TaskDto taskDto);

	CustomResponse fetchTaskByUsera();

	CustomResponse searchTask(SearchTaskDTO searchTaskDTO);

	CustomResponse updateTask(Task task);
}
