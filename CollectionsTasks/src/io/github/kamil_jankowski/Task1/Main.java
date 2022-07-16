package io.github.kamil_jankowski.Task1;

public class Main {
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
        positiveNumbers[7] = 9;

        int[] positiveNumbers2 = {3, 7, 1, 6, 8, 4, 5, 9};

        int missingNumber = findMissingNumber(positiveNumbers);
        int missingNumber2 = findMissingNumber(positiveNumbers2);

        System.out.printf("Missing numbers are:\n - missing number 1: %s\n - missing number 2: %s", missingNumber, missingNumber2);
    }

    private static int findMissingNumber(int[] numbers) {
        return 0;
    }
}
