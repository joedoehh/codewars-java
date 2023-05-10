package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.List;

public class PrimeDecomp {

    /**
     * Primes in numbers
     * 5 kyu
     * https://www.codewars.com/kata/54d512e62a5e54c96200019e/train/java
     */
    public static String factors(int n) {
        List<Integer> primeFactors = primeFactors(n);
        String returnValue = "";
        int lastNumber = 0;
        for (int nextNumber : primeFactors) {
            if (lastNumber == nextNumber)
                continue;
            lastNumber = nextNumber;    
            int count = occurences(primeFactors, nextNumber);            
            if (count > 1)
                returnValue += String.format("(%d**%d)", nextNumber, count); 
            else     
                returnValue += String.format("(%d)", nextNumber); 
        }
        return returnValue;
    }

    private static int occurences(List<Integer> numbers, int number) {
        int returnValue = 0;
        for (int next : numbers) 
            if (next == number)
                returnValue++;
        return returnValue;
    }

    private static List<Integer> primeFactors(int number) {
        int n = number;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

}