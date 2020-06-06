package com.todo.repository;

import com.todo.model.TaskTagMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskTagMappingRepository extends JpaRepository<TaskTagMapping,Integer> {
    @Override
    <S extends TaskTagMapping> List<S> saveAll(Iterable<S> iterable);
}
