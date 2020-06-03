package com.todo.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.constants.EnumConstants.ResponseStatus;
import com.todo.dto.SearchTaskDTO;
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
	public CustomResponse fetchTaskByUsera() {
		return null;
	}

	@Override
	public CustomResponse searchTask(SearchTaskDTO searchTaskDTO) {
		LOGGER.info("START::search-Task");
		List<Task> tasks = (List) searchAndFilterTask(searchTaskDTO);
		LOGGER.info("END::search-Task");
		return new CustomResponse("Searched tasks", tasks, ResponseStatus.SUCCESS.getCode());
	}

	private List<Object> searchAndFilterTask(SearchTaskDTO searchTaskDTO) {
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> cq = qb.createQuery();
		Root<Task> task = cq.from(Task.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (searchTaskDTO.getTaskId() != null) {
			predicates.add(qb.equal(task.get("taskId"), searchTaskDTO.getTaskId()));
		}

		if (searchTaskDTO.getColorCode() != null) {
			predicates.add(qb.equal(task.get("colorCode"), searchTaskDTO.getColorCode()));
		}

		if (searchTaskDTO.getFromEndDate() != null) {
			predicates.add(qb.greaterThanOrEqualTo(task.get("endDate"), searchTaskDTO.getFromEndDate()));
		}

		if (searchTaskDTO.getToEndDate() != null) {
			predicates.add(qb.lessThanOrEqualTo(task.get("endDate"), searchTaskDTO.getToEndDate()));
		}

		if (searchTaskDTO.getStatus() != null) {
			predicates.add(qb.equal(task.get("status"), searchTaskDTO.getStatus()));
		}

		if (searchTaskDTO.getTitle() != null) {
			predicates.add(qb.like(task.get("title"), searchTaskDTO.getTitle()));
		}

		if (searchTaskDTO.getTaskId() != null) {
			predicates.add(qb.equal(task.get("taskId"), searchTaskDTO.getTaskId()));
		}

		predicates.add(qb.equal(task.get("userId"), JwtUser.getCurrentUser().getId()));

		cq.select(task).where(predicates.toArray(new Predicate[] {}));

		return entityManager.createQuery(cq).getResultList();
	}

//	private Boolean deleteTaskbyId(Integer id) {
//		int isSuccessful = entityManager.createQuery("delete from task t where t.task_id=:taskId and t.id=:userId")
//				.setParameter("taskId", id).setParameter("userId", JwtUser.getCurrentUser().getId()).executeUpdate();
//		return isSuccessful > 0 ? true : false;
//	}

	@Override
	public CustomResponse addTask(Task task) {
		LOGGER.info("Started::Add-Task");

		if (task == null) {
			LOGGER.info("Task is null");
			return new CustomResponse("Task Can't added", false, ResponseStatus.FAILURE.getCode());
		}
		LOGGER.info("Task::" + task);
		// task.getUser().setId(JwtUser.getCurrentUser().getId());
		LOGGER.info("Task is getting added");
		Task returnedTask = taskRepository.save(task);
		if (taskRepository.findById(task.getTaskId()).isPresent()) {
			return new CustomResponse("Task Added SuccessFully", true, ResponseStatus.SUCCESS.getCode());
		} else {
			return new CustomResponse("Task Addition Failed", false, ResponseStatus.FAILURE.getCode());
		}
	}

	@Override
	public CustomResponse updateTask(Task task) {
		LOGGER.info("Update Task::Started");

		if (task == null) {
			LOGGER.info("Invalid Table");
			return new CustomResponse("Invalid Table", false, ResponseStatus.FAILURE.getCode());
		}

		int userId = taskRepository.findById(task.getTaskId()).get().getUser().getId();

		if (task.getUser().getId() == JwtUser.getCurrentUser().getId() && task.getUser().getId() == userId) {
			LOGGER.info("User is not authorised to update task");
			return new CustomResponse("User is not authorised to update task", false, ResponseStatus.FAILURE.getCode());
		}
		LOGGER.info("Task update starting");
		boolean flagCheck = false;
		if (taskRepository.findById(task.getTaskId()).isPresent()) {
			LOGGER.info("Task can't be updated , there is not such task");
			Task taskToUpdate = taskRepository.findById(task.getTaskId()).get();
			taskToUpdate.setStartDate(task.getStartDate());
			taskToUpdate.setEndDate(task.getEndDate());
			taskToUpdate.setStatus(task.getStatus());
			Task updatedTask = taskRepository.save(taskToUpdate);
			if (updatedTask.equals(task)) {
				flagCheck = true;
			}
			LOGGER.info("Task update starting");
		} else {
			LOGGER.info("Task can't be updated , there is not such task");
			return new CustomResponse("Task can't be updated , there is not such task", false,
					ResponseStatus.FAILURE.getCode());
		}
		LOGGER.info("Update Task::Ended");
		return flagCheck ? new CustomResponse("Task updated", true, ResponseStatus.FAILURE.getCode())
				: new CustomResponse("Task can't be updated", false, ResponseStatus.FAILURE.getCode());
	}

}
