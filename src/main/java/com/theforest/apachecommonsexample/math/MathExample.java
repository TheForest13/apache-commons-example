package com.theforest.apachecommonsexample.math;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.integration.UnivariateIntegrator;
import org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.fraction.FractionFormat;
import org.apache.commons.math3.geometry.euclidean.twod.Line;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.linear.*;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * Lightweight, self-contained mathematics and statistics components.
 */
public class MathExample {
    public static void main(String[] args) {
//        statistics();
//        probabilitiesAndDistributions();
//        rootFinding();
//        calculatingIntegrals();
//        linearAlgebra();
//        geometry();
        fractionAndComplexNumbers();
    }

    private static void fractionAndComplexNumbers() {
        Fraction lhs = new Fraction(1, 3);
        Fraction rhs = new Fraction(2, 5);
        Fraction sum = lhs.add(rhs);

        String str = new FractionFormat().format(sum);
        System.out.println(str);

        Complex first = new Complex(1.0, 3.0);
        Complex second = new Complex(2.0, 5.0);

        Complex power = first.pow(second);
        System.out.println(power);
    }


    private static void geometry() {
        Line l1 = new Line(new Vector2D(0, 0), new Vector2D(1, 1), 0);
        Line l2 = new Line(new Vector2D(0, 1), new Vector2D(1, 1.5), 0);

        Vector2D intersection = l1.intersection(l2);
        System.out.println(intersection);
    }

    private static void linearAlgebra() {
        RealMatrix a = new Array2DRowRealMatrix(
                new double[][] { { 2, 3, -2 }, { -1, 7, 6 }, { 4, -3, -5 } },
                false);
        RealVector b = new ArrayRealVector(new double[] { 1, -2, 1 },
        false);

        DecompositionSolver solver = new LUDecomposition(a).getSolver();

        RealVector solution = solver.solve(b);
        System.out.println(solution);
    }

    private static void calculatingIntegrals() {
        UnivariateFunction function = v -> v;
        UnivariateIntegrator integrator = new SimpsonIntegrator(1.0e-12, 1.0e-8, 1, 32);
        double i = integrator.integrate(100, function, 0, 10);
        System.out.println(i);
    }

    private static void rootFinding() {
        UnivariateFunction function = v -> Math.pow(v, 2) - 2;
        UnivariateSolver solver = new BracketingNthOrderBrentSolver(1.0e-12, 1.0e-8, 5);
        double c = solver.solve(100, function, -10.0, 10.0, 0);
        System.out.println(c);
    }

    private static void probabilitiesAndDistributions() {
        NormalDistribution normalDistribution = new NormalDistribution(10, 3);
        double randomValue = normalDistribution.sample();
        System.out.println(randomValue);
    }

    private static void statistics() {
        double[] values = new double[] {65, 51 , 16, 11 , 6519, 191 ,0 , 98, 19854, 1, 32};
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        for (double v : values) {
            descriptiveStatistics.addValue(v);
        }

        double mean = descriptiveStatistics.getMean();
        double median = descriptiveStatistics.getPercentile(50);
        double standardDeviation = descriptiveStatistics.getStandardDeviation();
        System.out.println("mean = " + mean);
        System.out.println("median = " + median);
        System.out.println("standardDeviation = " + standardDeviation);
    }
}
