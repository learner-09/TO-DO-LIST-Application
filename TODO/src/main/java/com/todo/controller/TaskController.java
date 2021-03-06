package com.todo.controller;

import com.todo.dto.TaskDto;
import com.todo.exceptions.TaskNotFound;
import com.todo.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.todo.dto.SearchTaskDTO;
import com.todo.model.CustomResponse;
import com.todo.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TaskController {

	final private Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	TaskService taskService;

	@DeleteMapping("/task/{id}")
	ResponseEntity<CustomResponse> deleteTask(@PathVariable Integer id) {
		LOGGER.info("start::deleteTask");
		CustomResponse customResponse = taskService.deleteTask(id);
		LOGGER.info("end::deleteTask");
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/add-task", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<CustomResponse> addTask(@RequestBody TaskDto taskDto) {
		LOGGER.info("Start::Add-Task");

		CustomResponse customResponse = taskService.addTask(taskDto);

		LOGGER.info("Finished::Add-Task");
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/search-task", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<CustomResponse> searchTask(@RequestBody SearchTaskDTO searchTaskDTO) {
		LOGGER.info("Start::Search-Task");

		CustomResponse customResponse = taskService.searchTask(searchTaskDTO);

		LOGGER.info("Finished::Search-Task");
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/update-task", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<CustomResponse> updateTask(@RequestBody Task task) {
		LOGGER.info("Start::Add-Task");

		CustomResponse customResponse = taskService.addTask(task);

		LOGGER.info("Finished::Add-Task");
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/init-task", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<CustomResponse> initTask() {
		LOGGER.info("Start::Init-Task");

		CustomResponse customResponse = taskService.initTask();

		LOGGER.info("Finished::Init-Task");
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}

}
