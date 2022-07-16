package io.github.kamil_jankowski.Task1;

import java.util.ArrayList;
import java.util.List;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println("Task 1");

        int[] positiveNumbers = initialize();

        List<Integer> positiveNumbers2 = new ArrayList<>(5);
        positiveNumbers2.add(4);
        positiveNumbers2.add(1);
        positiveNumbers2.add(5);
        positiveNumbers2.add(3);

        int missingNumber = findMissingNumber(positiveNumbers);
        int missingNumber2 = findMissingNumber(positiveNumbers2);

        System.out.printf("Missing numbers are:\n - missing number 1: %s\n - missing number 2: %s", missingNumber, missingNumber2);
    }

    private static int[] initialize() {
        int[] positiveNumbers = new int[8];
        positiveNumbers[0] = 3;
        positiveNumbers[1] = 7;
        positiveNumbers[2] = 1;
        positiveNumbers[3] = 2;
        positiveNumbers[4] = 8;
        positiveNumbers[5] = 4;
        positiveNumbers[6] = 5;
        return positiveNumbers;
    }

    /**
     * Finds missing number in an array of positive numbers from 1 to n,
     * such that all numbers from 1 to n are present except from one number.
     * @param numbers - input array
     * @return missing number
     * */
    private static int findMissingNumber(int[] numbers) {
        int sumOfAllNumbersFrom1toN;
        final int amountOfPairs = numbers.length / 2;
        final int sumOfAPair = numbers.length + 1;
        final int middleValue = numbers[amountOfPairs + 1];

        if(numbers.length % 2 == 0){
            sumOfAllNumbersFrom1toN = sumOfAPair * amountOfPairs;
        } else {
            sumOfAllNumbersFrom1toN = sumOfAPair * amountOfPairs + middleValue;
        }
        int sumOfNumbers = 0;

        for (int number : numbers) {
            sumOfNumbers += number;
        }

        return sumOfAllNumbersFrom1toN - sumOfNumbers;
    }

    private static int findMissingNumber(List<Integer> numbers) {
        int sumOfAllNumbersFrom1toN;
        final int expectedSizeOfCompletelyFilledList = numbers.size() + 1;
        final int amountOfPairs = expectedSizeOfCompletelyFilledList / 2;
        final int sumOfAPair = expectedSizeOfCompletelyFilledList + 1;
        final int middleValue = numbers.get(amountOfPairs + 1);
        int sumOfNumbers = 0;

        if(expectedSizeOfCompletelyFilledList % 2 == 0){
            sumOfAllNumbersFrom1toN = sumOfAPair * amountOfPairs;
        } else {
            sumOfAllNumbersFrom1toN = sumOfAPair * amountOfPairs + middleValue;
        }

        for (int number : numbers) {
            sumOfNumbers += number;
        }

        return sumOfAllNumbersFrom1toN - sumOfNumbers;
    }
}
