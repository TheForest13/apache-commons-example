package com.theforest.apachecommonsexample.beanutils.stuff;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseEntity {
    private String name;
    private List<String> codes;
    private Map<String, Student> students = new HashMap<>();

    @Override
    public String toString() {
        return "CourseEntity{" +
                "name='" + name + '\'' +
                ", codes=" + codes +
                ", students=" + students +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }

    public Map<String, Student> getStudents() {
        return students;
    }

    public void setStudents(Map<String, Student> students) {
        this.students = students;
    }
}
