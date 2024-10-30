package com.aecode.webcoursesback.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usercourseaccess")
@SequenceGenerator(name = "access_seq", sequenceName = "access_sequence", allocationSize = 1)

public class UserCourseAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "access_seq")
    private int accessId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile userProfile;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public UserCourseAccess() {
    }

    public UserCourseAccess(int accessId, UserProfile userProfile, Course course) {
        this.accessId = accessId;
        this.userProfile = userProfile;
        this.course = course;
    }

    public int getAccessId() {
        return accessId;
    }

    public void setAccessId(int accessId) {
        this.accessId = accessId;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
