package com.joedoe.cwjava;

public class RobotPath {

    /**
     * You are a Robot: Translating a Path
     * 6 kyu
     * https://www.codewars.com/kata/636173d79cf0de003d6834e4/train/java
     */
    public static String walk(String path) {
        if (null == path || path.length() == 0)
            return "Paused";
        StringBuffer result = new StringBuffer();
        int nrOfSteps = 0;
        char lastChar = path.charAt(0);
        for (int i = 0; i < path.length(); i++) {
            if (lastChar == path.charAt(i))
                nrOfSteps++;
            else {
                if (result.length() > 0)
                    result.append("\n");
                appendMessage(nrOfSteps, lastChar, result);
                nrOfSteps = 1;
            }
            lastChar = path.charAt(i);
        }
        if (result.length() > 0)
            result.append("\n");
        appendMessage(nrOfSteps, lastChar, result);
        return result.toString();
    }

    private static void appendMessage(int nrOfSteps, char character, StringBuffer result) {
        String direction = "unknown";
        switch (character) {
            case '<':
                direction = "left";
                break;
            case '>':
                direction = "right";
                break;
            case '^':
                direction = "up";
                break;
            case 'v':
                direction = "down";
                break;
        }
        result.append(String.format("Take %d %s %s", nrOfSteps, nrOfSteps == 1 ? "step" : "steps", direction));
    }

}