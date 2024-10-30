package com.aecode.webcoursesback.dtos;

import com.aecode.webcoursesback.entities.RelatedWork;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class ModuleDTO {
    private int moduleId;
    private int courseId;
    private String title;
    private int orderNumber;
    private List<UnitDTO> units;
    private RelatedWorkDTO relatedworks;

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<UnitDTO> getUnits() {
        return units;
    }

    public void setUnits(List<UnitDTO> units) {
        this.units = units;
    }

    public RelatedWorkDTO getRelatedworks() {
        return relatedworks;
    }

    public void setRelatedworks(RelatedWorkDTO relatedworks) {
        this.relatedworks = relatedworks;
    }
}

