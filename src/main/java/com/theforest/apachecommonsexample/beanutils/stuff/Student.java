package com.theforest.apachecommonsexample.beanutils.stuff;

import lombok.Getter;
import lombok.Setter;


public class Student {
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
