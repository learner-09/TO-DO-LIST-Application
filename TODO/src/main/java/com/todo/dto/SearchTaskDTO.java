package com.todo.dto;

import java.sql.Date;

public class SearchTaskDTO {

	private Integer taskId;
	private String title;
	private Date fromEndDate;
	private Date toEndDate;
	private Short status;
	private String colorCode;
	private String orderBy;
	private String sortType;
	private Integer tagId;

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

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

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchTaskDTO [taskId=").append(taskId).append(", title=").append(title)
				.append(", fromEndDate=").append(fromEndDate).append(", toEndDate=").append(toEndDate)
				.append(", status=").append(status).append(", colorCode=").append(colorCode).append(", orderBy=")
				.append(orderBy).append(", sortType=").append(sortType).append(", tagId=").append(tagId).append("]");
		return builder.toString();
	}

}
