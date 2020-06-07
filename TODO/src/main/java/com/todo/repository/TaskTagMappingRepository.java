package com.todo.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.todo.dto.TaskTagDto;
import com.todo.model.TaskTagMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskTagMappingRepository extends JpaRepository<TaskTagMapping,Integer> {
    @Override
    <S extends TaskTagMapping> S save(S s);
}
