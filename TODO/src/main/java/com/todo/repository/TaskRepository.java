package com.todo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	Boolean deleteByTaskIdAndUserId(Integer taskId, Integer userId);

	@Override
	Task save(Task task);//will work for task add and task update

	@Override
	Page<Task> findAll(Pageable pageable);//help:-https://howtodoinjava.com/spring-boot2/pagination-sorting-example/

	@Override
	List<Task> findAll(Sort sort);

	@Override
	Optional<Task> findById(Integer integer);

	@Override
	boolean existsById(Integer integer);
}
