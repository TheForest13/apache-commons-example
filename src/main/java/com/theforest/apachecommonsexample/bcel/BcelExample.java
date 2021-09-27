package com.theforest.apachecommonsexample.bcel;

import lombok.extern.slf4j.Slf4j;
import org.apache.bcel.Repository;
import org.apache.bcel.classfile.Code;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Byte Code Engineering Library - analyze, create, and manipulate Java class files
 */

public class BcelExample {

    private final static Logger log = LoggerFactory.getLogger(BcelExample.class);

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
//        instanceOfClass();
//        accessingClassFileData();

    }

    /**
     * Анализ методов в классе
     *
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    private static void accessingClassFileData() throws ClassNotFoundException, NoSuchMethodException {
        JavaClass clazz = Repository.lookupClass("com.theforest.apachecommonsexample.bcel.BcelExample");
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            log.debug("accessingClassFileData() clazz.getMethods() = {}", methods[i]);
            Code code = methods[i].getCode();
            if (code != null) // Non-abstract method
                log.debug("accessingClassFileData() methods[i].getCode() = {}", methods[i].getCode());
        }
    }

    /**
     * используя предоставленный класс Repository, можно прочитать файлы классов в объект JavaClass
     * Проверка принадлежности класса к супер-классу
     *
     * @throws ClassNotFoundException
     */
    private static void instanceOfClass() throws ClassNotFoundException {
        JavaClass clazz = Repository.lookupClass("java.lang.Integer");
        JavaClass super_class = Repository.lookupClass("java.lang.Number");
        if (Repository.instanceOf(clazz, super_class)) {
            log.debug("instanceOfClass() Repository.instanceOf(clazz, super_class) true");
        }
        if (Repository.instanceOf(super_class, clazz)) {
            log.debug("instanceOfClass() Repository.instanceOf(super_class, clazz) = true");
        } else {
            log.debug("instanceOfClass() Repository.instanceOf(super_class, clazz) = false");
        }
    }
}
