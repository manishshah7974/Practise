package com.Work.SampleProject.Model;
public class Record {
    private int intern_id;
    private String name;

    private String email;

    private String mobile;

    private String course_id;
    private String manager_id;

    public Record(){}
    public Record(int intern_id, String name, String email, String mobile, String course_id, String manager_id) {
        this.intern_id = intern_id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.course_id = course_id;
        this.manager_id = manager_id;
    }

    public int getIntern_id() {
        return intern_id;
    }

    public void setIntern_id(int intern_id) {
        this.intern_id = intern_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;

    }

    @Override
    public String toString() {
        return "Record{" +
                "intern_id=" + intern_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", course_id='" + course_id + '\'' +
                ", manager_id='" + manager_id + '\'' +
                '}';
    }
}
