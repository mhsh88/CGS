package ir.behinehsazan.gasStation.model.mathCalculation;

import java.util.List;

public class MathCalculation {

    public static Double dotProduct(Double[] a, Double[] b) {
        Double product = 0.0;
        if (a.length != b.length) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < a.length; i++) {
            product += a[i] * b[i];
        }

        return product;

    }
    public static Double dotProduct(Double[] a, double[] b) {
        Double product = 0.0;
        if (a.length != b.length) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < a.length; i++) {
            product += a[i] * b[i];
        }

        return product;

    }
    public static Double dotProduct(double[] a, double[] b) {
        Double product = 0.0;
        if (a.length != b.length) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < a.length; i++) {
            product += a[i] * b[i];
        }

        return product;

    }


    public static Double[] powProduct(double[] vector, double power) {
        Double[] product = new Double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            product[i] = Math.pow(vector[i], power);
        }

        return product;
    }

    public static Double listSum(List<Double> sumlist) {
        Double sum = 0.0;
        for (Double d : sumlist) {
            sum += d;
        }
        return sum;

    }
    public static Double listSum(Double[] sumlist) {
        Double sum = 0.0;
        for (Double d : sumlist) {
            sum += d;
        }
        return sum;

    }
}
