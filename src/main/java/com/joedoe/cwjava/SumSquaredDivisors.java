package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class SumSquaredDivisors {

    public static String listSquared(long m, long n) {
        List<LongTupel2> result = new ArrayList<>();
        for (long x = m; x <= n; x++) {
            LongTupel2 tuple = calculateSumOfSquaresOfFactors(x);
            double r = Math.sqrt((double) tuple.y);
            if (r - ((long) r) == 0)
                result.add(tuple);
        }
        return result.toString();
    }

    private static LongTupel2 calculateSumOfSquaresOfFactors(long n) {
        long limit = (long) Math.sqrt((double) n);
        long sum =  LongStream.rangeClosed(1, limit)
                 .filter(x -> n % x == 0)
                 .reduce(0, (acc, x) -> sumSquaredWrtRemainder(n, x, acc));
        return new LongTupel2(n, sum);
    }

    private static long sumSquaredWrtRemainder(long n, long x, long acc) {
        long r = n / x;
        if (x == r)
            return acc + x*x;
        else
            return acc + x*x + r*r;
    }

    private record LongTupel2(Long x, Long y) {
        @Override
        public String toString() {
            return "["+x+", "+y+"]";
        }
    }
}
