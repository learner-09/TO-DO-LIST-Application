package com.todo.dto;

public class TaskTagDto {
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
}
