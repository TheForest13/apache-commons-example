package com.theforest.apachecommonsexample.rng;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

import java.util.Arrays;

/**
 * Implementations of random numbers generators.
 */
public class RngExample {
    public static void main(String[] args) {
        UniformRandomProvider rng = RandomSource.MT.create();
        boolean isOn = rng.nextBoolean(); // "true" or "false".
        System.out.println("\"true\" or \"false\" = " + isOn);

        int n = rng.nextInt(); // Integer.MIN_VALUE <= n <= Integer.MAX_VALUE.
        System.out.println("Integer.MIN_VALUE <= n <= Integer.MAX_VALUE = " + n);

        int m = rng.nextInt(10); // 0 <= m < max.
        System.out.println("0 <= m < max = " + m);

        long n2 = rng.nextLong(); // Long.MIN_VALUE <= n <= Long.MAX_VALUE.
        System.out.println("Long.MIN_VALUE <= n <= Long.MAX_VALUE = " + n2);

        long m2 = rng.nextLong(10); // 0 <= m < max.
        System.out.println("0 <= m < max = " + m2);

        float x = rng.nextFloat(); // 0 <= x < 1.
        System.out.println("0 <= x < 1 = " + x);

        double x2 = rng.nextDouble(); // 0 <= x < 1.
        System.out.println("0 <= x < 1 = " + x2);

        int seed = RandomSource.createInt();
        System.out.println("int seed = " + seed);

        long seed2 = RandomSource.createLong();
        System.out.println("long seed = " + seed2);

        int[] seed3 = RandomSource.createIntArray(128); // Length of returned array is 128.
//        Arrays.stream(seed3).forEach(e -> System.out.println("int[] seed = " + e));

        long[] seed4 = RandomSource.createLongArray(128); // Length of returned array is 128.
//        Arrays.stream(seed4).forEach(e -> System.out.println("long[] seed = " + e));

    }
}
