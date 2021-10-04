package com.theforest.apachecommonsexample.text;

import org.apache.commons.text.StringSubstitutor;

import java.util.HashMap;
import java.util.Map;

/**
 * Apache Commons Text is a library focused on algorithms working on strings.
 */
public class TextExample {
    public static void main(String[] args) {
//        replaceJavaSystemProperties();

//        usingCustomMap();

    }

    private static void usingCustomMap() {
        // Build map
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("animal", "quick brown fox");
        valuesMap.put("target", "lazy dog");
        String templateString = "The ${animal} jumped over the ${target}.";

        // Build StringSubstitutor
        StringSubstitutor sub = new StringSubstitutor(valuesMap);

        // Replace
        String resolvedString = sub.replace(templateString);
        System.out.println(resolvedString);
    }

    private static void replaceJavaSystemProperties() {
        // replace Java System properties
        String str = StringSubstitutor.replaceSystemProperties(
                "You are running with java.version = ${java.version} and os.name = ${os.name}.");
        System.out.println(str);
    }
}
