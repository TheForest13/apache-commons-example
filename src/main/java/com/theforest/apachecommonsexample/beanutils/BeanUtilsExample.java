package com.theforest.apachecommonsexample.beanutils;

import com.theforest.apachecommonsexample.beanutils.stuff.Course;
import com.theforest.apachecommonsexample.beanutils.stuff.CourseEntity;
import com.theforest.apachecommonsexample.beanutils.stuff.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Easy-to-use wrappers around the Java reflection and introspection APIs.
 *
 * Компонент Bean Introspection Utilities подпроекта Apache Commons предлагает низкоуровневые служебные классы,
 * которые помогают получать и устанавливать значения свойств для классов Java, которые следуют шаблонам проектирования имен,
 * описанным в спецификации JavaBeans,
 * а также механизмы для динамического определения и доступа к свойствам bean-компонентов. .
 */
public class BeanUtilsExample {

    private final static Logger log = LoggerFactory.getLogger(BeanUtilsExample.class);

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
//        copyPropertiesObject();
//        setProperties();

        getNestedProperties();
    }

    private static void getNestedProperties() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Course course = new Course();
        Student student = new Student();
        String studentName = "Joe";
        student.setName(studentName);
        course.setEnrolledStudent("ST-1", student);
//        String name = course.getEnrolledStudent("ST-1").getName();
//        System.out.println(name);

//        Student student = new Student();
//        String studentName = "Joe";
//        student.setName(studentName);

        String nameValue
                = (String) PropertyUtils.getNestedProperty(
                course, "enrolledStudent(ST-1).name");
        System.out.println(nameValue);
    }

    /**
     * Установка полей в обьекте
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    private static void setProperties() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Course course = new Course();
        String name = "Computer Science";
        List<String> codes = Arrays.asList("CS", "CS01");
        log.debug("setProperties() before course = {}", course);
        PropertyUtils.setSimpleProperty(course, "name", name);
        PropertyUtils.setSimpleProperty(course, "codes", codes);
        log.debug("setProperties() after course = {}", course);
    }

    /**
     * Скопируйте свойства компонента
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private static void copyPropertiesObject() throws IllegalAccessException, InvocationTargetException {
        Course course = new Course();
        course.setName("Computer Science");
        course.setCodes(Arrays.asList("CS"));

        CourseEntity courseEntity = new CourseEntity();
        BeanUtils.copyProperties(courseEntity, course);
        log.debug("copyPropertiesObject() courseEntity = {}", courseEntity);
    }
}
