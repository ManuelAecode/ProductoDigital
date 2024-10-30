package com.aecode.webcoursesback.dtos;

import java.util.List;

public class CourseDTO {
    private int courseId;
    private String title;
    private String videoUrl;
    private List<ModuleDTO> modules;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ModuleDTO> getModules() {
        return modules;
    }

    public void setModules(List<ModuleDTO> modules) {
        this.modules = modules;
    }
}
