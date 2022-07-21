package io.github.kamil_jankowski.task11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println("Task 11: Find all subsets of a given set of integers");

        Integer[] ints = new Integer[] {8,13,3,22, 17, 39, 87, 45, 36};
        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, ints);

        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(3);
        integers.add(4);

        List<HashSet<Integer>> subsetsOf3 = getAllSubsets(integers);
        List<HashSet<Integer>> subsetsOf9 = getAllSubsets(integerList);

        printAll(subsetsOf3);
//        printAll(subsetsOf9);
    }

    static List<HashSet<Integer>> getAllSubsets(List<Integer> integers) {
        List<HashSet<Integer>> subsets = new ArrayList<>();
        int subsets_count = (int)(Math.pow(2, integers.size()));    // amount of possible subsets for n elements = 2^n

        for (int i = 0; i < subsets_count; i++) {
            HashSet<Integer> subset = new HashSet<>();     // set to store each possible subset

            for (int j = 0; j < integers.size(); j++) {
                if (getBit(i, j) == 1) {
                    subset.add(integers.get(j));
                }
            }

            subsets.add(subset);
        }
        return subsets;
    }

    static int getBit(int num, int bit) {
        int temp = (1 << bit);      // shift 1 to the left by bit value
        temp = temp & num;          // binary AND to verify if there is a bit in number at given position
        if (temp == 0) {            // no bit - return 0 - no int will be read from the list in parent method
            return 0;
        }
        return 1;                   // there is a bit - return 1 - parent method will verify true and read the value from given index
    }

    private static void printAll(List<HashSet<Integer>> subsets) {
        System.out.println("**** Subsets *****");
        for (HashSet<Integer> subset : subsets) {
            System.out.print("{ ");
            for (Integer it : subset) {
                System.out.print(it + " ");
            }
            System.out.println("}");
        }
        System.out.println("**** Total ***** = " + subsets.size());
    }
}
