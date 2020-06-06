package com.todo.service;

import com.todo.model.TaskTagMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskTagMappingService{
    boolean addTags(List<TaskTagMapping> taskTagMappings);
}
