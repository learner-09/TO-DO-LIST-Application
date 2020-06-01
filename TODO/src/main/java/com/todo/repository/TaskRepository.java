package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.model.Task;

@org.springframework.stereotype.Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	Boolean deleteByTaskIdAndUserId(Integer taskId, Integer userId);

	@Override
	<S extends Task> S save(S s);
}
