package io.github.kamil_jankowski.task14;

import java.util.Arrays;
import java.util.List;

public class LowHigh {
    public static void main(String[] args) {
        System.out.println("Task 14: Find Low/High Index");

        Integer[] testArray = new Integer[]{1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6};
        List<Integer> testList = Arrays.asList(testArray);
        int lowIndexOf1 = findLowIndex(testList, 1);
        System.out.println("Low 1: " + lowIndexOf1);
        int highIndexOf1 = findHighIndex(testList, 1);
        int lowIndexOf2 = findLowIndex(testList, 2);
        System.out.println("Low 2: " + lowIndexOf2);
        int highIndexOf2 = findHighIndex(testList, 2);
        int lowIndexOf3 = findLowIndex(testList, 3);
        System.out.println("Low 3: " + lowIndexOf3);
        int highIndexOf3 = findHighIndex(testList, 3);
        int lowIndexOf4 = findLowIndex(testList, 4);
        System.out.println("Low 4: " + lowIndexOf4);
        int highIndexOf4 = findHighIndex(testList, 4);
        int lowIndexOf5 = findLowIndex(testList, 5);
        System.out.println("Low 5: " + lowIndexOf5);
        int highIndexOf5 = findHighIndex(testList, 5);
        int lowIndexOf6 = findLowIndex(testList, 6);
        System.out.println("Low 6: " + lowIndexOf6);
        int highIndexOf6 = findHighIndex(testList, 6);
        int lowIndexOf7 = findLowIndex(testList, 7);
        System.out.println("Low 7: " + lowIndexOf7);
        int highIndexOf7 = findHighIndex(testList, 7);

        System.out.println("High: ");
        System.out.println(highIndexOf1);
        System.out.println(highIndexOf2);
        System.out.println(highIndexOf3);
        System.out.println(highIndexOf4);
        System.out.println(highIndexOf5);
        System.out.println(highIndexOf6);
        System.out.println(highIndexOf7);
    }

    /**
     * Finds the lowest index of a given value in the SORTED list provided.
     * @param testList - sorted list of integers
     * @param key - value of integer to found
     * @return - the lowest index for which given key is placed in the list, -1 if no key is found in the list
     */
    private static int findLowIndex(List<Integer> testList, int key) {
        // initial definition of indexes needed to perform binary search:
        int lowIndex = 0;
        int highIndex = testList.size()-1;

        // as long as low index is lower or equal than high
        while (lowIndex <= highIndex){
            // define middle index for given boundaries
            int midIndex = lowIndex + (highIndex - lowIndex)/2;
            // if the middle index value is lower that the key,
            // then the key must (if) present be at higher half of the list
            if (testList.get(midIndex) < key){
                // therefore, we are now moving lowIndex to the first index of a higher half
                lowIndex = midIndex +1;
            // else, if the middle index value is equal or greater than the key,
            // then lowest index of key value (if) present is in lower half of the list
            } else {
                // therefore, we are now moving highIndex to the last index of a lower half
                highIndex = midIndex - 1;
            }
        } // while loop constantly decreases its size to focus on the lowest index for key value

        // if low index is still within the list AND after while loop, last stored low index value is equal to the key
        if (lowIndex < testList.size() && testList.get(lowIndex) == key){
            return lowIndex;
        } else {
            return -1;
        }
    }

    /**
     * Finds the highest index of a given value in the SORTED list provided.
     * @param testList - sorted list of integers
     * @param key - value of integer to found
     * @return - the highest index for which given key is placed in the list, -1 if no key is found in the list
     */
    private static int findHighIndex(List<Integer> testList, int key) {
        // initial definition of indexes needed to perform binary search:
        int lowIndex = 0;
        int highIndex = testList.size()-1;

        // as long as low index is lower or equal than high
        while (lowIndex <= highIndex){
            // define middle index for given boundaries
            int midIndex = lowIndex + (highIndex - lowIndex)/2;
            // if the middle index value is higher that the key,
            // then the key must (if) present be at lower half of the list
            if (testList.get(midIndex) > key){
                // therefore, we are now moving highIndex to the first last of a lower half
                highIndex = midIndex - 1;
                // else, if the middle index value is equal or less than the key,
                // then highest index of key value (if) present is in higher half of the list
            } else {
                // therefore, we are now moving lowIndex to the first index of a higher half
                lowIndex = midIndex + 1;
            }
        } // while loop constantly decreases its size to focus on the highest index for key value

        // if high index is still within the list AND after while loop, last stored high index value is equal to the key
        if (highIndex >= 0 && testList.get(highIndex) == key){
            return highIndex;
        } else {
            return -1;
        }
    }
}
