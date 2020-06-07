package com.todo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.todo.dto.TaskTagDto;
import com.todo.model.TaskTagMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskTagMappingService{
    boolean addTags(TaskTagDto taskTagMappings);
}
