package com.Work.SampleProject.Model;
import jakarta.persistence.*;
@Entity
@Table(name = "course")
public class Course {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int course_id;

    @Column(name = "course_list")
    private String course_list;

    public Course(){}
    public Course(int course_id, String course_list) {
        this.course_id = course_id;
        this.course_list = course_list;
    }
    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_list() {
        return course_list;
    }

    public void setCourse_list(String course_list) {
        this.course_list = course_list;
    }
    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_list='" + course_list + '\'' +
                '}';
    }
}
