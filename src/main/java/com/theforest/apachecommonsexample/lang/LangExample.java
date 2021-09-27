package com.theforest.apachecommonsexample.lang;

import com.theforest.apachecommonsexample.lang.stuff.User;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.commons.lang3.concurrent.LazyInitializer;
import org.apache.commons.lang3.math.Fraction;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides extra functionality for classes in java.lang.
 */
public class LangExample {
    public static void main(String[] args) {
//        StringUtilsExample.execute();
//        ArrayUtilsExample.execute();
//        NumberUtilsExample.execute();
//        FractionExample.execute();
//        SystemUtilsExample.execute();
        LazyInitializerExample.execute();
    }

    private static class StringUtilsExample {
        static void execute() {
            System.out.println("StringUtils.isBlank(\" \") = " + StringUtils.isBlank(" "));
            System.out.println("StringUtils.isEmpty(\"\") = " + StringUtils.isEmpty(""));
            System.out.println("StringUtils.isAllLowerCase(\"abd\") = " + StringUtils.isAllLowerCase("abd"));
            System.out.println("StringUtils.isAllUpperCase(\"ABC\") = " + StringUtils.isAllUpperCase("ABC"));
            System.out.println("StringUtils.isMixedCase(\"abC\") = " + StringUtils.isMixedCase("abC"));
            System.out.println("StringUtils.isAlpha(\"abc\") = " + StringUtils.isAlpha("abc"));
            System.out.println("StringUtils.isAlphanumeric(\"abc123\") = " + StringUtils.isAlphanumeric("abc123"));
        }
    }

    private static class ArrayUtilsExample {
        static void execute() {
            String[] array = {"a", "b", "c"};
            System.out.println("ArrayUtils.toString(array) = " + ArrayUtils.toString(null, "Array is null"));
            System.out.println("ArrayUtils.toString(null, \"Array is null\") = " + ArrayUtils.toString(null, "Array is null"));
            System.out.println("ArrayUtils.hashCode(array) = " + ArrayUtils.hashCode(array));

            String[][] array2 = {{"1", "one",}, {"2", "two",}, {"3", "three"}};
            Map map = new HashMap();
            map.put("1", "one");
            map.put("2", "two");
            map.put("3", "three");
            System.out.println("ArrayUtils.toMap(array2) = " + ArrayUtils.toMap(array2));

            int[] array3 = {1, 2, 3};
            int[] array4 = {1, 2, 3};
            System.out.println("ArrayUtils.isSameLength(array3, array4) = " + ArrayUtils.isSameLength(array3, array4));

            int[] array5 = {1, 2, 3};
            System.out.println("ArrayUtils.indexOf(array5, 1, 0) = " + ArrayUtils.indexOf(array5, 1, 0));
        }
    }

    private static class NumberUtilsExample {
        static void execute() {
            System.out.println("NumberUtils.compare(1, 1) = " + NumberUtils.compare(1, 1));
            System.out.println("NumberUtils.compare(1L, 1L) = " + NumberUtils.compare(1L, 1L));
            System.out.println("NumberUtils.createNumber(\"123456\") = " + NumberUtils.createNumber("123456"));
            System.out.println("NumberUtils.isDigits(\"123456\") = " + NumberUtils.isDigits("123456"));

            int[] array = {1, 2, 3, 4, 5, 6};
            System.out.println("NumberUtils.max(array) = " + NumberUtils.max(array));
            System.out.println("NumberUtils.min(array) = " + NumberUtils.min(array));

            byte[] array2 = {1, 2, 3, 4, 5, 6};
            System.out.println("NumberUtils.min(array2) = " + NumberUtils.min(array2));
        }
    }

    private static class FractionExample {
        static void execute() {
            System.out.println("Fraction.getFraction(5, 6) = " + Fraction.getFraction(5, 6));

            Fraction fraction1 = Fraction.getFraction(1, 4);
            Fraction fraction2 = Fraction.getFraction(3, 4);
            System.out.println("fraction1.add(fraction2) = " + fraction1.add(fraction2));

            Fraction fraction3 = Fraction.getFraction(3, 4);
            Fraction fraction4 = Fraction.getFraction(1, 4);
            System.out.println("fraction3.subtract(fraction4) = " + fraction3.subtract(fraction4));

            Fraction fraction5 = Fraction.getFraction(3, 4);
            Fraction fraction6 = Fraction.getFraction(1, 4);
            System.out.println("fraction5.multiplyBy(fraction6) = " + fraction5.multiplyBy(fraction6));
        }
    }

    private static class SystemUtilsExample {
        static void execute() {
            System.out.println("SystemUtils.getJavaHome() = " + SystemUtils.getJavaHome());
            System.out.println("SystemUtils.getUserHome() = " + SystemUtils.getUserHome());
            System.out.println("SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_RECENT) = " +
                    SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_RECENT));
        }
    }


    private static class LazyInitializerExample {
        static void execute() {
            LazyInitializerExample example = new LazyInitializerExample();
            UserInitializer userInitializer = example.new UserInitializer();
            User user = userInitializer.initialize();
            System.out.println(user);

            int hashcode = new HashCodeBuilder(17, 37)
                    .append("John")
                    .append("john@domain.com")
                    .toHashCode();
            System.out.println("hashcode = " + hashcode);

            BasicThreadFactory factory = new BasicThreadFactory.Builder()
                    .namingPattern("workerthread-%d")
                    .daemon(true)
                    .priority(Thread.MAX_PRIORITY)
                    .build();
            System.out.println("factory = " + factory);
        }

        class UserInitializer extends LazyInitializer<User> {
            @Override
            protected User initialize() {
                return new User("John", "john@domain.com");
            }
        }


    }
}
