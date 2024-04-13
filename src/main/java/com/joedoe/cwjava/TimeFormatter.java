package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {

    private static List<Unit> units = new ArrayList<>();

    static {
        units.add(new Unit("year", 60 * 60 * 24 * 365));
        units.add(new Unit("day", 60 * 60 * 24));
        units.add(new Unit("hour", 60 * 60));
        units.add(new Unit("minute", 60));
        units.add(new Unit("second", 1));
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0) return "now";

        // reduce per unit
        List<Unit> unitsForSeconds = new ArrayList<>();
        for (Unit nextUnit : units) {
            int value = seconds / nextUnit.inSeconds;
            if (value == 1) unitsForSeconds.add(new Unit(nextUnit.unitName, value));
            else if (value > 1) unitsForSeconds.add(new Unit(nextUnit.unitName+"s", value));
            seconds = seconds % nextUnit.inSeconds;
        }

        // format result
        String formatted = "";
        for (Unit nextUnit : unitsForSeconds)
            formatted += nextUnit.inSeconds + " " + nextUnit.unitName + ", ";
        formatted = formatted.substring(0, formatted.length()-2);

        // transform last "," to "and"
        if (unitsForSeconds.size() >= 2) {
            int lastIndex = formatted.lastIndexOf(",");
            String before = formatted.substring(0, lastIndex);
            String after = formatted.substring(lastIndex+1);
            formatted =  before + " and" + after;
        }

        return formatted;
    }

    private record Unit(String unitName, int inSeconds) {}
}
