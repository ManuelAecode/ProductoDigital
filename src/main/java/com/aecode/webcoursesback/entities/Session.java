package com.aecode.webcoursesback.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "sessions")
@SequenceGenerator(name = "session_seq", sequenceName = "session_sequence", allocationSize = 1)
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "session_seq")
    private int sessionId;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(length = 255)
    private String videoUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column( length = 255)
    private String resourceDocument;
 
    @Column(nullable = false)
    private int orderNumber;

    @OneToOne(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private SessionTest sessiontests;

    @Column(length = 255)
    private String taskName;

    @Column(length = 255)
    private String taskUrl;

    public Session() {
    }

    public Session(int sessionId, Unit unit, String title, String videoUrl, String description, String resourceDocument, int orderNumber, SessionTest sessiontests, String taskName, String taskUrl) {
        this.sessionId = sessionId;
        this.unit = unit;
        this.title = title;
        this.videoUrl = videoUrl;
        this.description = description;
        this.resourceDocument = resourceDocument;
        this.orderNumber = orderNumber;
        this.sessiontests = sessiontests;
        this.taskName = taskName;
        this.taskUrl = taskUrl;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
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

    public SessionTest getSessiontests() {
        return sessiontests;
    }

    public void setSessiontests(SessionTest sessiontests) {
        this.sessiontests = sessiontests;
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
}
