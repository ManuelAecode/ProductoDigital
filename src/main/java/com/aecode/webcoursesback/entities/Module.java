package com.aecode.webcoursesback.entities;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "modules")
@SequenceGenerator(name = "module_seq", sequenceName = "module_sequence", allocationSize = 1)
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "module_seq")
    private int moduleId;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false)
    private int orderNumber;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Unit> units =  new ArrayList<>();

    @OneToOne(mappedBy = "module", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RelatedWork relatedworks;

    public Module() {
    }

    public Module(int moduleId, Course course, String title, int orderNumber, List<Unit> units, RelatedWork relatedworks) {
        this.moduleId = moduleId;
        this.course = course;
        this.title = title;
        this.orderNumber = orderNumber;
        this.units = units;
        this.relatedworks = relatedworks;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public RelatedWork getRelatedworks() {
        return relatedworks;
    }

    public void setRelatedworks(RelatedWork relatedworks) {
        this.relatedworks = relatedworks;
    }
}
