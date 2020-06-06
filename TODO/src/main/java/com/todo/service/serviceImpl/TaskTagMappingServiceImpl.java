package com.todo.service.serviceImpl;

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
    public boolean addTags(List<TaskTagMapping> taskTagMappings) {
        List<TaskTagMapping> list=taskTagMappingRepository.saveAll(taskTagMappings);
        return true;
    }
}
