package com.theforest.apachecommonsexample.jxpath.stuff;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
public class Employee {
    String firstName;

    public Employee(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}
