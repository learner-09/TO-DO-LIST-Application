package com.todo.repository;

import org.springframework.data.repository.Repository;

import com.todo.model.Task;

@org.springframework.stereotype.Repository
public interface TaskRepository extends Repository<Task, Integer> {

	Boolean deleteByTaskIdAndCreatedBy(Integer taskId, Integer createdBy);

}
