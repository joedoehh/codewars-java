package com.joedoe.cwjava;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SumFct {
    public static BigInteger perimeter(BigInteger n) {
        List<BigInteger> length = new ArrayList<>();
        BigInteger accuX = new BigInteger("1");
        BigInteger accuY = new BigInteger("1");
        long i=0;
        while (i <= n.longValue()) {
            length.add(accuX);
            BigInteger sum = accuX.add(accuY);
            accuX = accuY;
            accuY = sum;
            i++;
        }
        BigInteger sum = length.stream().reduce(BigInteger.ZERO, BigInteger::add);
        return sum.multiply(BigInteger.valueOf(4));
    }
}