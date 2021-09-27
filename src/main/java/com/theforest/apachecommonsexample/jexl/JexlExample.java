package com.theforest.apachecommonsexample.jexl;


import org.apache.commons.jexl3.*;

/**
 * Expression language which extends the Expression Language of the JSTL.
 */
public class JexlExample {
    private static final JexlEngine jexl = new JexlBuilder().cache(512).strict(true).silent(false).create();

    public static void main(String[] args) {
       // пока не понятно

        // Assuming we have a JexlEngine instance initialized in our class named 'jexl':
        // Create an expression object for our calculation
        String calculateTax = "((G1 + G2 + G3) * 0.1) + G4";
        JexlExpression e = jexl.createExpression( calculateTax );

        // populate the context
        JexlContext context = new MapContext();
        context.set("G1", 1);
        context.set("G2", 2);
        context.set("G3", 3);
        context.set("G4", 4);
        // ...

        // work it out
        Number result = (Number) e.evaluate(context);
        System.out.println(result);
    }
}