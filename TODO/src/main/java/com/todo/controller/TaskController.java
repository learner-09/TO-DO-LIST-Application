package com.todo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.todo.model.CustomResponse;
import com.todo.service.TaskService;

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

}
