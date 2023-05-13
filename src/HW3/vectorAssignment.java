package HW3;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.stream.IntStream;

public class vectorAssignment {
    public vectorAssignment() {
    }

    public static double[] getSubVector(double[] vector, int index, int n) {
        double[] subVector = new double[n];
        if (index - 1 + n > vector.length - 1) {
            System.out.println("invalid value");
            return subVector;
        } else {
            for(int i = 0; i < subVector.length; ++i) {
                subVector[i] = vector[index - 1];
                ++index;
            }

            return subVector;
        }
    }

    public static double[] sum(double[] vector1, double[] vector2) {
        double[] sum = new double[vector1.length];

        for(int i = 0; i < sum.length; ++i) {
            sum[i] = vector1[i] + vector2[i];
        }

        return sum;
    }

    public static double[] product(double k, double[] vector) {
        double[] product = new double[vector.length];

        for(int i = 0; i < product.length; ++i) {
            product[i] = k * vector[i];
        }

        return product;
    }

    public static double[] difference(double[] vector1, double[] vector2) {
        double[] difference = sum(vector1, product(-1.0, vector2));
        return difference;
    }

    public static double product(double[] vec1, double[] vec2) {
        double product = 0.0;

        for(int i = 0; i < vec1.length; ++i) {
            product += vec1[i] * vec2[i];
        }

        return product;
    }

    public static double norm(double[] vec) {
        return Math.sqrt(product(vec, vec));
    }

    public static double distance(double[] vec1, double[] vec2) {
        return norm(difference(vec1, vec2));
    }

    public static boolean equals(double threshold, double[] vec1, double[] vec2) {
        if (vec1.length != vec2.length) {
            return false;
        } else {
            for(int i = 0; i < vec1.length; ++i) {
                if (Math.abs(vec1[i] - vec2[i]) > threshold) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean equals(double[] a, double[] b) {
        return a.length != b.length ? false : IntStream.range(0, a.length).parallel().allMatch((i) -> {
            return equals(a[i], b[i]);
        });
    }

    public static boolean equals(double a, double b) {
        double THRESHOLD = 1.0E-10;
        return Math.abs(a - b) < 1.0E-10;
    }

    public static void main(String[] args) {
        System.out.println("shamoonintrotocs.SampleHW1.main()");
        System.out.println("Testing methods in SampleHW1.java \n The word false should never appear below.");
        double[] a = new double[]{1.0, 2.0, 3.0};
        double[] b = new double[]{4.0, 5.0, 6.0};
        boolean[] tests = new boolean[]{equals(sum(a, b), new double[]{5.0, 7.0, 9.0}), equals(product(2.0, a), new double[]{2.0, 4.0, 6.0}), equals(difference(a, b), new double[]{-3.0, -3.0, -3.0}), equals(product(a, b), 32.0), equals(distance(a, b), Math.sqrt(27.0)), equals(norm(a), Math.sqrt(14.0)), !equals(1.0E-10, a, b) && equals(a, new double[]{1.0, 2.0, 3.0})};
        System.out.println("Passes sum test: " + tests[0]);
        System.out.println("Passes scalar product test: " + tests[1]);
        System.out.println("Passes difference test: " + tests[2]);
        System.out.println("Passes dot procut test: " + tests[3]);
        System.out.println("Passes distance test: " + tests[4]);
        System.out.println("Passes norm test: " + tests[5]);
        System.out.println("Passes equals theshold test: " + tests[6]);
        boolean passesAllTests = true;
        boolean[] var5 = tests;
        int var6 = tests.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            boolean test = var5[var7];
            passesAllTests &= test;
        }

        System.out.println("Passes all tests: " + passesAllTests);
    }
}
