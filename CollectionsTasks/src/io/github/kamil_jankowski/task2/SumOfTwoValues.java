package io.github.kamil_jankowski.task2;

import java.util.HashSet;
import java.util.Set;

public class SumOfTwoValues {
    public static void main(String[] args) {
        System.out.println("Task 2: Sum of two values");

        int[] numbers = initializeArray();

        final boolean sumOfTwoTrue1 = findSumOfTwo(numbers, 10);
        System.out.println("_");
        final boolean sumOfTwoTrue2 = findSumOfTwo(numbers, 3);
        System.out.println("_");
        final boolean sumOfTwoTrue3 = findSumOfTwo(numbers, 7);
        System.out.println("_");
        final boolean sumOfTwoFalse1 = findSumOfTwo(numbers, 2);
        System.out.println("_");
        final boolean sumOfTwoFalse2 = findSumOfTwo(numbers, 19);

        System.out.println("Target sum = 10 possible: " + sumOfTwoTrue1);
        System.out.println("Target sum = 2 possible: " + sumOfTwoFalse1);
        System.out.println("Target sum = 3 possible: " + sumOfTwoTrue2);
        System.out.println("Target sum = 7 possible: " + sumOfTwoTrue3);
        System.out.println("Target sum = 19 possible: " + sumOfTwoFalse2);
    }

    private static int[] initializeArray() {
        final int[] array = new int[7];
        array[0]=5;
        array[1]=7;
        array[2]=1;
        array[3]=2;
        array[4]=8;
        array[5]=4;
        array[6]=3;
        return array;
    }

    private static boolean findSumOfTwo(int[] array, int sumToBeFound) {
        // rewrite the array to the hash set
        Set<Integer> set = new HashSet<>();
        for(int number : array){    // O(n)
            set.add(number);        // O(1)
        }

        boolean possible = false;
        // while iterating over the set, check if the set contains sumToBeFound-currentValue
        for(int value : set){       // O(n)
            possible = set.contains(sumToBeFound - value) && (sumToBeFound-value) != value;      // O(1)
            System.out.println(value + " is possible with " +sumToBeFound+": " + possible);
            if (possible) break;
        }
        return possible;
    }
}
