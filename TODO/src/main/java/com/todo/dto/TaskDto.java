package com.todo.dto;

import com.todo.model.TaskTagMapping;
import com.todo.model.User;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.util.List;

public class TaskDto {

    private int taskId;
    private String title;
    private String description;
    private Date createdDate;
    private Date updatedDate;
    private Date startDate;
    private Date endDate;
    private Short status;
    private String colorCode;
    private Boolean notifyOptContact;
    private Boolean notifyOptEmail;
    private Boolean notifyOptWeb;
    private String urlToImage;
    private String location;
    private Double locationLat;
    private Double locationLong;
    private User user;
    private List<TaskTagMapping> tagMappingList;

    public TaskDto() {
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Boolean getNotifyOptContact() {
        return notifyOptContact;
    }

    public void setNotifyOptContact(Boolean notifyOptContact) {
        this.notifyOptContact = notifyOptContact;
    }

    public Boolean getNotifyOptEmail() {
        return notifyOptEmail;
    }

    public void setNotifyOptEmail(Boolean notifyOptEmail) {
        this.notifyOptEmail = notifyOptEmail;
    }

    public Boolean getNotifyOptWeb() {
        return notifyOptWeb;
    }

    public void setNotifyOptWeb(Boolean notifyOptWeb) {
        this.notifyOptWeb = notifyOptWeb;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(Double locationLat) {
        this.locationLat = locationLat;
    }

    public Double getLocationLong() {
        return locationLong;
    }

    public void setLocationLong(Double locationLong) {
        this.locationLong = locationLong;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<TaskTagMapping> getTagMappingList() {
        return tagMappingList;
    }

    public void setTagMappingList(List<TaskTagMapping> tagMappingList) {
        this.tagMappingList = tagMappingList;
    }
}
