package com.joedoe.cwjava;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumber {

    /**
     * Find the unique number
     * 6 kyu
     * https://www.codewars.com/kata/585d7d5adb20cf33cb000235/train/java
     */    
    public static double findUniq(double arr[]) {
	    Map<Double, Integer> occurences = new HashMap<>();
	    for (double next : arr) {
            Integer count = occurences.get(next);
            if (null == count) 
                count = 0;
            occurences.put(next, count+1);
	    }
        for (Map.Entry<Double,Integer> entry : occurences.entrySet()) {
		    if (entry.getValue() == 1)
			    return entry.getKey();
        }
	    return 0;
      }

}
