package io.github.kamil_jankowski.task2;

public class SumOfTwoValues {
    public static void main(String[] args) {
        System.out.println("Task 2: Sum of two values");

        int[] numbers = initializeArray();

        int possibleTargetSum = 10;
        int notPossibleTargetSum = 19;

        final boolean sumOfTwoTrue = findSumOfTwo(numbers, possibleTargetSum);
        final boolean sumOfTwoFalse = findSumOfTwo(numbers, notPossibleTargetSum);

        System.out.println("Target sum = 10 possible: " + sumOfTwoTrue);
        System.out.println("Target sum = 19 possible: " + sumOfTwoFalse);
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
        //TODO: Write - Your - Code
        return false;
    }
}
