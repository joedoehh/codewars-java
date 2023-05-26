package com.joedoe.cwjava;

import java.util.Map;

/**
 * Tour
 * 5 kyu
 * https://www.codewars.com/kata/5536a85b6ed4ee5a78000035/train/java
 */
public class Tour {

    public static int tour(String[] arrFriends, String[][] ftwns, Map<String, Double> h) {
        double distance = 0.0;
        double lastDistance = -1.0;
        for (String nextFriend : arrFriends) {
            // get distance to town (and skip unknown towns)
            String nextTown = null;
            for (String[] nextFtwStrings : ftwns) {
                if (nextFriend.equals(nextFtwStrings[0])) {
                    nextTown = nextFtwStrings[1];
                    break;
                }
            }
            if (nextTown == null)
                continue;

            if (!h.containsKey(nextTown))
                continue;
            double nextDistance = h.get(nextTown);

            // add distance: special case first distance, compute otherwise
            if (lastDistance < 0) {
                distance += nextDistance;
            } else {
                distance += Math.sqrt(nextDistance * nextDistance - lastDistance * lastDistance);
            }
            lastDistance = nextDistance;
        }
        distance += lastDistance;
        return (int) distance;
    }

}