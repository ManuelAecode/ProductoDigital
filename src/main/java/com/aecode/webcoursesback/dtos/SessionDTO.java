package com.aecode.webcoursesback.dtos;

public class SessionDTO {

    private int sessionId;
    private int unitId;
    private String title;
    private String videoUrl;
    private String description;
    private String resourceText;
    private String resourceDocument;
    private int orderNumber;
    private String taskName;
    private String taskUrl;
    private SessionTestDTO sessiontests;
    private String HtmlContent;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceText() {
        return resourceText;
    }

    public void setResourceText(String resourceText) {
        this.resourceText = resourceText;
    }

    public String getResourceDocument() {
        return resourceDocument;
    }

    public void setResourceDocument(String resourceDocument) {
        this.resourceDocument = resourceDocument;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskUrl() {
        return taskUrl;
    }

    public void setTaskUrl(String taskUrl) {
        this.taskUrl = taskUrl;
    }

    public SessionTestDTO getSessiontests() {
        return sessiontests;
    }

    public void setSessiontests(SessionTestDTO sessiontests) {
        this.sessiontests = sessiontests;
    }

    public String getHtmlContent() {
        return HtmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        HtmlContent = htmlContent;
    }
}
