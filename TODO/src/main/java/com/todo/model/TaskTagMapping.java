package com.todo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "taskId", "tagId" }))
@Entity
public class TaskTagMapping {

	@Id
	private int id;

	private int taskId;
	private Short tagId;

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
