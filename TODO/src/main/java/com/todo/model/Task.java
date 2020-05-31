package com.todo.model;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;
    private String title;
    private String description;
    @Column(name = "created_date")
    private String createdDate;
    @Column(name = "updated_date")
    private String updatedDate;
    private String startDate;
    private String endDate;
    private String status;
    private String colorCode;
    @Column(name = "Notiy_Optional_Contact",unique = true)
    private String notifyOptionalContact;
    @Column(name = "Notiy_Optional_Email",unique = true)
    private String notifyOptionalEmail;
    private String notifyOptionalWeb;
    private String urlToImage;
    private String urlToLocation;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    public Task() {
    }

    public int gettaskId() {
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getNotifyOptionalContact() {
        return notifyOptionalContact;
    }

    public void setNotifyOptionalContact(String notifyOptionalContact) {
        this.notifyOptionalContact = notifyOptionalContact;
    }

    public String getNotifyOptionalEmail() {
        return notifyOptionalEmail;
    }

    public void setNotifyOptionalEmail(String notifyOptionalEmail) {
        this.notifyOptionalEmail = notifyOptionalEmail;
    }

    public String getNotifyOptionalWeb() {
        return notifyOptionalWeb;
    }

    public void setNotifyOptionalWeb(String notifyOptionalWeb) {
        this.notifyOptionalWeb = notifyOptionalWeb;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getUrlToLocation() {
        return urlToLocation;
    }

    public void setUrlToLocation(String urlToLocation) {
        this.urlToLocation = urlToLocation;
    }

    public User getUser() {
        return user;
    }

    public void setUserid(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", updatedDate='" + updatedDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status='" + status + '\'' +
                ", colorCode='" + colorCode + '\'' +
                ", notifyOptionalContact='" + notifyOptionalContact + '\'' +
                ", notifyOptionalEmail='" + notifyOptionalEmail + '\'' +
                ", notifyOptionalWeb='" + notifyOptionalWeb + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", urlToLocation='" + urlToLocation + '\'' +
                ", user=" + user +
                '}';
    }
}
