package com.joedoe.cwjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeWithIncorrectValue {

    private record Node(int idx, int idxLeft, int idxRight, int v, int vLeft, int vRight, boolean hasLeaves) {
    }

    /**
     * Finding the incorrect value in a Binary Tree
     * 6 kyu
     * https://www.codewars.com/kata/63f13a354a828b0041979359/train/java
     */
    public static int[] findIncorrectNumber(int[] tree) {
        System.out.println(Arrays.toString(tree));
        int[] failure = new int[] { 0, 0 };
        boolean foundFailure = false;
        for (Node node : createNodes(tree)) {
            if (node.v != node.vLeft + node.vRight) {
                if (!foundFailure && node.hasLeaves) {
                    // keep this value not to introduce new other errors && repair right leave
                    failure = new int[] { node.idxRight, node.v - node.vLeft };
                    foundFailure = true;

                } else {
                    // repair here on this level
                    failure = new int[] { node.idx, node.vLeft + node.vRight };
                    foundFailure = true;
                }
            }
        }
        return failure;

    }

    private static List<Node> createNodes(int[] tree) {
        List<Node> returnValue = new ArrayList<>();
        int[] leafIndex = indexForemostLayer(tree.length);
        for (int i = 0; i < tree.length; i++) {
            int idx = i;
            int idxLeft = 2 * idx + 1;
            if (idxLeft == tree.length)
                break;
            int idxRight = idxLeft + 1;
            boolean hasLeaves = i >= leafIndex[0] && i <= leafIndex[1];
            returnValue.add(new Node(idx, idxLeft, idxRight, tree[idx], tree[idxLeft], tree[idxRight], hasLeaves));
        }
        return returnValue;
    }

    private static int[] indexForemostLayer(int nrNodes) {
        int maxLevel = calculateMaxTreeHeight(nrNodes);
        int nrOfNodesLeafLevel = (int) Math.pow(2, maxLevel);
        int nrOfNodesLeafLevelMinusOne = (int) Math.pow(2, maxLevel - 1);
        return new int[] { nrNodes - nrOfNodesLeafLevel - nrOfNodesLeafLevelMinusOne,
                nrNodes - nrOfNodesLeafLevel - 1 };
    }

    private static int calculateMaxTreeHeight(int nrNodes) {
        int nrNodesInPerfectTree = 2;
        for (int height = 1; height < nrNodes / 2; height++) {
            nrNodesInPerfectTree *= 2;
            if (nrNodes == nrNodesInPerfectTree - 1)
                return height;
        }
        return 0;
    }

}
