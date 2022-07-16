package io.github.kamil_jankowski.Task1;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println("Task 1");

        int[] positiveNumbers = new int[8];
        positiveNumbers[0] = 3;
        positiveNumbers[1] = 7;
        positiveNumbers[2] = 1;
        positiveNumbers[3] = 2;
        positiveNumbers[4] = 8;
        positiveNumbers[5] = 4;
        positiveNumbers[6] = 5;

        int[] positiveNumbers2 = new int[5];
        positiveNumbers2[0] = 4;
        positiveNumbers2[1] = 1;
        positiveNumbers2[2] = 5;
        positiveNumbers2[3] = 3;

        int missingNumber = findMissingNumber(positiveNumbers);
        int missingNumber2 = findMissingNumber(positiveNumbers2);

        System.out.printf("Missing numbers are:\n - missing number 1: %s\n - missing number 2: %s", missingNumber, missingNumber2);
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
}
