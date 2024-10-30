package com.aecode.webcoursesback.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "userprogresssessions")
@SequenceGenerator(name = "progresssession_seq", sequenceName = "progresssession_sequence", allocationSize = 1)

public class UserProgressSession {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "progresssession_seq")
    private int progressId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile userProfile;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @Column(nullable = false)
    private boolean isCompleted;

    public UserProgressSession() {
    }

    public UserProgressSession(int progressId, UserProfile userProfile, Session session, boolean isCompleted) {
        this.progressId = progressId;
        this.userProfile = userProfile;
        this.session = session;
        this.isCompleted = isCompleted;
    }

    public int getProgressId() {
        return progressId;
    }

    public void setProgressId(int progressId) {
        this.progressId = progressId;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
