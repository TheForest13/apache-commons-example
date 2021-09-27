package com.theforest.apachecommonsexample.ognl;

import ognl.Ognl;
import ognl.OgnlException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * An Object-Graph Navigation Language
 */
public class OgnlExample {
    public static void main(String[] args) {
        //не понимаю
        try {
            System.out.println(Ognl.getValue("x", new Point(5, 5)));
            System.out.println(Ognl.getValue("size", new ArrayList<Object>(Arrays.asList(1,2,3))));
        } catch (OgnlException e) {
            e.printStackTrace();
        }
    }
}
