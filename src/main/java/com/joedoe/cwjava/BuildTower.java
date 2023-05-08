package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuildTower {


    /**
     * Build Tower
     * 6 kyu
     * https://www.codewars.com/kata/576757b1df89ecf5bd00073b/train/java
     */
    public static String[] towerBuilder(int nFloors) {
        if (nFloors < 1) 
            return new String[0];
        List<String> tower = new ArrayList<>();
        towerBuild(1, nFloors, 1, tower);
        Collections.reverse(tower);
        return tower.toArray(new String[tower.size()]);
    }

    private static int towerBuild(int level, int nFloors, int numberOfStars, List<String> tower) {
        if (level == nFloors) {
            tower.add(createBlock(numberOfStars, "*"));
            return numberOfStars;
        } else {
            int sizeBelow = towerBuild(level+1, nFloors, numberOfStars+2, tower);
            int paddingLength = (sizeBelow - numberOfStars) / 2;
            String levelString = createBlock(paddingLength, " ") + createBlock(numberOfStars, "*") + createBlock(paddingLength, " ");
            tower.add(levelString);
            return sizeBelow;
        }
    }

    private static String createBlock(int size, String template) {
        StringBuffer returnValue = new StringBuffer();
        for (int i = 0; i < size; i++) {
            returnValue.append(template);
        }
        return returnValue.toString();
    }

}
