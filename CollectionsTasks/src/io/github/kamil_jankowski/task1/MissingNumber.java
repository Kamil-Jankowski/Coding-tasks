package io.github.kamil_jankowski.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println("Task 1");

        int[] positiveNumbers = initialize();

        List<Integer> positiveNumbers2 = new ArrayList<>();
        positiveNumbers2.add(4);
        positiveNumbers2.add(1);
        positiveNumbers2.add(5);
        positiveNumbers2.add(3);

        int missingNumber = findMissingNumber(positiveNumbers);
        int missingNumber2 = findMissingNumber(positiveNumbers2);

        System.out.printf("Missing numbers are:\n - missing number 1: %s\n - missing number 2: %s\n\n", missingNumber, missingNumber2);

        for (int n = 0; n < 10; ++n)
            test(100000);
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


    static void test(int n) {
        int missing_element = (new Random()).nextInt(n) + 1;
        List<Integer> v = new ArrayList<>();

        for(int i = 1; i <= n; ++i) {
            if (i != missing_element)
                v.add(i);
        }

        int actual_missing = findMissingNumber(v);
        System.out.print("Expected Missing = ");
        System.out.print(missing_element);
        System.out.print(" Actual Missing = ");
        System.out.println(actual_missing);
        System.out.println("Missing Element == Actual Missing : "+ (missing_element == actual_missing));
    }

}

