package com.aecode.webcoursesback.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "userprogressunit")
@SequenceGenerator(name = "progressunit_seq", sequenceName = "progressunit_sequence", allocationSize = 1)

public class UserProgressUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "progressunit_seq")

    private int progressId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile userProfile;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    @Column(nullable = false)
    private boolean isCompleted;

    public UserProgressUnit() {
    }

    public UserProgressUnit(int progressId, UserProfile userProfile, Unit unit, boolean isCompleted) {
        this.progressId = progressId;
        this.userProfile = userProfile;
        this.unit = unit;
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

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
