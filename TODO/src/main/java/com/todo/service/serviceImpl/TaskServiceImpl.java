package com.todo.service.serviceImpl;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.todo.constants.EnumConstants.ResponseStatus;
import com.todo.jwt.JwtUser;
import com.todo.model.CustomResponse;
import com.todo.model.Task;
import com.todo.repository.TaskRepository;
import com.todo.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	final private Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);

	@Autowired
	EntityManager entityManager;

	@Autowired
	TaskRepository taskRepository;

	@Override
	public CustomResponse deleteTask(Integer id) {
		LOGGER.info("start::deleteTask");
		CustomResponse customResponse = null;
		if (taskRepository.deleteByTaskIdAndUserId(id, JwtUser.getCurrentUser().getId())) {
			customResponse = new CustomResponse("Task deleted successfully", true, ResponseStatus.SUCCESS.getCode());
		} else {
			customResponse = new CustomResponse("Unable to delete task", false, ResponseStatus.FAILURE.getCode());
		}
		LOGGER.info("end::deleteTask");
		return customResponse;
	}

	@Override
	public CustomResponse addTask(Task task) {
		LOGGER.info("Started::Add-Task");

		if(task==null){
			LOGGER.info("Task is null");
			return new CustomResponse("Task Can't added",false,ResponseStatus.FAILURE.getCode());
		}

		if(task.getUser().getId()!=JwtUser.getCurrentUser().getId()){
			LOGGER.info("Task can't be created::User id MisMatch");
			return new CustomResponse("Task can't be created::User id MisMatch",false,ResponseStatus.FAILURE.getCode());
		}
		LOGGER.info("Task is getting added");
		Task returnedTask=taskRepository.save(task);
		if (taskRepository.findById(task.getTaskId()).isPresent()){
			return new CustomResponse("Task Added SuccessFully",true,ResponseStatus.SUCCESS.getCode());
		}else {
			return new CustomResponse("Task Addition Failed",false,ResponseStatus.FAILURE.getCode());
		}
	}

    @Override
    public CustomResponse updateTask(Task task) {
        LOGGER.info("Update Task::Started"+task);

        if(task==null){
            LOGGER.info("Invalid Table");
            return new CustomResponse("Invalid Table",false,ResponseStatus.FAILURE.getCode());
        }

        int userId=taskRepository.findById(task.getTaskId()).get().getUser().getId();

        LOGGER.info(task.getUser().getId()+" "+JwtUser.getCurrentUser().getId()+" "+userId+"");
        if(!(task.getUser().getId()==JwtUser.getCurrentUser().getId() && task.getUser().getId()==userId)){
            LOGGER.info("User is not authorised to update task");
            return new CustomResponse("User is not authorised to update task",false,ResponseStatus.FAILURE.getCode());
        }
        LOGGER.info("Task update starting");
        boolean flagCheck=false;
        if(taskRepository.findById(task.getTaskId()).isPresent()){
            LOGGER.info("Task can't be updated , there is not such task");
            Task taskToUpdate=taskRepository.findById(task.getTaskId()).get();
            taskToUpdate.setTitle(task.getTitle());
            taskToUpdate.setDescription(task.getDescription());
            taskToUpdate.setStartDate(task.getStartDate());
            taskToUpdate.setEndDate(task.getEndDate());
            taskToUpdate.setStatus(task.getStatus());
            taskToUpdate.setUpdatedDate(task.getUpdatedDate());
            Task updatedTask=taskRepository.save(taskToUpdate);
            if(updatedTask.equals(task)){flagCheck=true;LOGGER.info("Task Updated Successfully");}
        }else{
            LOGGER.info("Task can't be updated , there is not such task");
            return new CustomResponse("Task can't be updated , there is not such task",false,ResponseStatus.FAILURE.getCode());
        }
        LOGGER.info("Update Task::Ended");
	    return flagCheck?new CustomResponse("Task updated",true,ResponseStatus.SUCCESS.getCode()):new CustomResponse("Task can't be updated",false,ResponseStatus.FAILURE.getCode());
    }

    @Override
	public CustomResponse fetchTaskByUsera() {
		return null;
	}

//	private Boolean deleteTaskbyId(Integer id) {
//		int isSuccessful = entityManager.createQuery("delete from task t where t.task_id=:taskId and t.id=:userId")
//				.setParameter("taskId", id).setParameter("userId", JwtUser.getCurrentUser().getId()).executeUpdate();
//		return isSuccessful > 0 ? true : false;
//	}

}
/*{
	"title":"1st task for userid 67",
	"description":"first task and its get updated++++++++++++======+++++++++++++++++++++++++++++=======================",
	"createdDate":"2015-03-31",
	"updatedDate":"2015-03-31",
	"startDate":"2015-03-31",
	"endDate":"2015-03-31",
	"status":"1",
	"colorCode":"red",
	"notifyOptContact":"true",
	"notifyOptEmail":"false",
	"notifyOptWeb":"false",
	"urlToImage":"dd",
	"location":"lko",
	"locationLat":"333.333",
	"locationLong":"233.33",
	"user":{
		"id":67
	}
}
   { "name":"abhishek",
    "userName":"abhishek",
    "password":"password",
    "email": "aa@a.com",
    "contact": 7379012345,
    "createdDate": "1-06-2020",
    "createdMode": "manual"}*/