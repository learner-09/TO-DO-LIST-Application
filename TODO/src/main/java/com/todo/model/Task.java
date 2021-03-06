package com.todo.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;
    private String title;
    private String description;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "updated_date")
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

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public Task(String title, String description, Date createdDate, Date updatedDate, Date startDate, Date endDate, Short status, String colorCode, Boolean notifyOptContact, Boolean notifyOptEmail, Boolean notifyOptWeb, String urlToImage, String location, Double locationLat, Double locationLong,User user) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.colorCode = colorCode;
        this.notifyOptContact = notifyOptContact;
        this.notifyOptEmail = notifyOptEmail;
        this.notifyOptWeb = notifyOptWeb;
        this.urlToImage = urlToImage;
        this.location = location;
        this.locationLat = locationLat;
        this.locationLong = locationLong;
        this.user=user;
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

    @Override
    public boolean equals(Object obj) {
        Task task = (Task) obj;
        return this.getTaskId() == task.getTaskId() && this.getTitle().equals(task.getTitle()) && this.getDescription().equals(task.getDescription()) && this.getStartDate().equals(task.getStartDate())
                && this.getStatus() == task.getStatus()
                && this.getUpdatedDate().equals(task.getUpdatedDate());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Task [taskId=").append(taskId).append(", title=").append(title).append(", description=")
                .append(description).append(", createdDate=").append(createdDate).append(", updatedDate=")
                .append(updatedDate).append(", startDate=").append(startDate).append(", endDate=").append(endDate)
                .append(", status=").append(status).append(", colorCode=").append(colorCode)
                .append(", notifyOptContact=").append(notifyOptContact).append(", notifyOptEmail=")
                .append(notifyOptEmail).append(", notifyOptWeb=").append(notifyOptWeb).append(", urlToImage=")
                .append(urlToImage).append(", location=").append(location).append(", locationLat=").append(locationLat)
                .append(", locationLong=").append(locationLong).append(", user=").append(user).append("]");
        return builder.toString();
    }

}
