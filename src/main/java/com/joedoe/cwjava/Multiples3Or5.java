package com.joedoe.cwjava;

public class Multiples3Or5 {

    /**
     * Multiples of 3 or 5
     * 6 kyu
     * https://www.codewars.com/kata/514b92a657cdc65150000006/train/java
     */
    public int solution(int number) {
        if (number <= 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < number; i++) {
            if (multiple(i, 3) || multiple(i, 5)) 
                sum += i;
        }
        return sum;
    }
    
    private boolean multiple(int number, int divisor) {
        return number % divisor == 0;
    }

}
