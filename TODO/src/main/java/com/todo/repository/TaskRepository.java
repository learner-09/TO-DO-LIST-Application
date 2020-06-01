package com.todo.repository;

import org.springframework.data.repository.Repository;

import com.todo.model.Task;

@org.springframework.stereotype.Repository
public interface TaskRepository extends Repository<Task, Integer> {

	Boolean deleteByTaskIdAndUserId(Integer taskId, Integer userId);

}
