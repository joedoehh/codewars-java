package com.joedoe.cwjava;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SameMatrix {

    private record Matrix(int a, int b, int c, int d) {

        private boolean equals(Matrix other) {
            return a == other.a && b == other.b && c == other.c && d == other.d;
        }

        private Matrix rotate90Degree() {
            return new Matrix(c, a, d, b);
        }

        public static Matrix fromArray(int[] values) {
            if (values == null || values.length != 4)
                throw new RuntimeException(
                        "matrix has to be made up from exact four values but was " + Arrays.toString(values));
            return new Matrix(values[0], values[1], values[2], values[3]);
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Matrix))
                return false;
            Matrix otherMatrix = (Matrix) other;
            boolean equal = equals(otherMatrix) || //
                    equals(otherMatrix.rotate90Degree()) || //
                    equals(otherMatrix.rotate90Degree().rotate90Degree()) || //
                    equals(otherMatrix.rotate90Degree().rotate90Degree().rotate90Degree());
            return equal;
        }

        @Override
        public int hashCode() {
            return a + b + c + d;
        }

        @Override
        public String toString() {
            return String.format("[[%d,%d][%d,%d]]", a, b, c, d);
        }

    }

    /**
     * Same matrix (2 * 2)
     * 6 kyu
     * https://www.codewars.com/kata/635fc0497dadea0030cb7936/train/java
     */
    public static int count_different_matrices(int[][] matrices) {
        Set<Matrix> setOfMatrices = new HashSet<>();
        for (int i = 0; i < matrices.length; i++)
            setOfMatrices.add(Matrix.fromArray(matrices[i]));
        return setOfMatrices.size();
    }

}
