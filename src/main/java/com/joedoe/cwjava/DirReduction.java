package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        List<String> path = Arrays.asList(arr);
        List<String> result = dirReduc(path);
        return result.toArray(new String[0]);
    }

    private static List<String> dirReduc(List<String> path) {
        List<String> result =
                reducePath(new ArrayList<>(path), "", new ArrayList<>());
        if (result.size() == path.size())
            return result;
        else
            return dirReduc(result);
    }

    private static List<String> reducePath(List<String> path, String last, List<String> acc) {
        if (path.isEmpty()) return acc;
        if (acc.isEmpty()) {
            String firstElement = path.remove(0);
            acc.add(firstElement);
            return reducePath(path, firstElement, acc);
        }
        if (isOpposite(path.get(0), last)) {
            path.remove(0);
            acc.remove(acc.size()-1);
            return reducePath(path,"REMOVED", acc);
        }
        String firstElement = path.remove(0);
        acc.add(firstElement);
        return reducePath(path, firstElement, acc);
    }

    private static boolean isOpposite(String dir1, String dir2) {
        if (dir1.equals("NORTH") && dir2.equals("SOUTH")) return true;
        if (dir1.equals("EAST") && dir2.equals("WEST")) return true;
        if (dir1.equals("SOUTH") && dir2.equals("NORTH")) return true;
        return dir1.equals("WEST") && dir2.equals("EAST");
    }

}
