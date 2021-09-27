package com.theforest.apachecommonsexample.jxpath;

import com.theforest.apachecommonsexample.jxpath.stuff.Employee;
import org.apache.commons.jxpath.JXPathContext;

/**
 * Utilities for manipulating Java Beans using the XPath syntax.
 */
public class JXPathExample {
    public static void main(String[] args) {
        Employee emp = new Employee("Old");
        JXPathContext context = JXPathContext.newContext(emp);
        String fName = (String) context.getValue("firstName");
        System.out.println(fName);
    }
}
