package com.joedoe.cwjava;

import java.math.BigInteger;

public class BitCount {

    public static BigInteger countOnes(long left, long right) {
        return new BitCount(left, right).solution();
    }

    private final long left;
    private final long right;

    public BitCount(long left, long right) {
        this.left = left;
        this.right = right;
    }

    public BigInteger solution() {
        return countOnes(right).subtract(countOnes(left - 1));
    }

    private BigInteger countOnes(long right) {
        if (right == 0) {
            return BigInteger.valueOf(0);
        }
        int size = (Long.toBinaryString(right).length()) - 1;
        long power = (long) 1 << size;
        return BigInteger
                .valueOf(size)
                .multiply(BigInteger.valueOf(power / 2))
                .add(BigInteger.valueOf(1 + right - power))
                .add(countOnes(right - power));
    }

}