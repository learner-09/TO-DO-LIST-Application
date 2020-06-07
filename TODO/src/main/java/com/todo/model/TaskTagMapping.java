package com.todo.model;

import javax.persistence.*;
import java.util.UUID;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "taskId", "tagId" }))
@Entity
public class TaskTagMapping {

	@Id
	private String id;

	private int taskId;
	private Short tagId;

	public TaskTagMapping() {
	}

	public TaskTagMapping(String id, int taskId, Short tagId) {
		this.id=id;
		this.taskId = taskId;
		this.tagId = tagId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Short getTagId() {
		return tagId;
	}

	public void setTagId(Short tagId) {
		this.tagId = tagId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaskTagMapping [taskId=").append(taskId).append(", tagId=").append(tagId).append("]");
		return builder.toString();
	}

}