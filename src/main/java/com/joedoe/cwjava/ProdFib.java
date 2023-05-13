package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.List;

public class ProdFib {

    /**
     * Product of consecutive Fib numbers
     * 5 kyu
     * https://www.codewars.com/kata/5541f58a944b85ce6d00006a/train/java
     */
    public static long[] productFib(long prod) {
        List<Long> fibs = fib(prod);
        long product = 0;
        int n=1;
        while (product < prod) {
            product = fibs.get(n-1)*fibs.get(n);
            n++; 
        }
        if (product == prod)
            return new long[] {fibs.get(n-2), fibs.get(n-1), 1l};
        else
            return new long[] {fibs.get(n-2), fibs.get(n-1), 0l};
    }

    private static List<Long> fib(long n) {
        List<Long> result = new ArrayList<>();
        result.add(0l);
        result.add(1l);
        for (int i=2; result.get(result.size()-1)  <= n; i++)   
            result.add(result.get(i-2)+result.get(i-1)); 
        return result;
    }

}