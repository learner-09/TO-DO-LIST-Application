package com.todo.service.serviceImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.todo.dto.TaskTagDto;
import com.todo.model.TaskTagMapping;
import com.todo.repository.TaskTagMappingRepository;
import com.todo.service.TaskTagMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskTagMappingServiceImpl implements TaskTagMappingService {

    @Autowired
    TaskTagMappingRepository taskTagMappingRepository;

    @Override
    public boolean addTags(TaskTagDto taskTag) {
       // TaskTagMapping taskTagMappings=new TaskTagMapping(taskTag.getTaskId(),taskTag.getTagId());
        //TaskTagMapping list=taskTagMappingRepository.save(taskTagMappings);
        return true;
    }
}
