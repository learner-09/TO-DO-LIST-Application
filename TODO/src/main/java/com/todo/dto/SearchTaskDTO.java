package com.todo.dto;

import java.sql.Date;

public class SearchTaskDTO {

	private Integer taskId;
	private String title;
	private Date fromEndDate;
	private Date toEndDate;
	private Short status;
	private String colorCode;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getFromEndDate() {
		return fromEndDate;
	}

	public void setFromEndDate(Date fromEndDate) {
		this.fromEndDate = fromEndDate;
	}

	public Date getToEndDate() {
		return toEndDate;
	}

	public void setToEndDate(Date toEndDate) {
		this.toEndDate = toEndDate;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchTaskDTO [taskId=").append(taskId).append(", title=").append(title)
				.append(", fromEndDate=").append(fromEndDate).append(", toEndDate=").append(toEndDate)
				.append(", status=").append(status).append(", colorCode=").append(colorCode).append("]");
		return builder.toString();
	}
}
