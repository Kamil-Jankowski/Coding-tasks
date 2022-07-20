package io.github.kamil_jankowski.task9;

import java.util.Arrays;

public class CoinChangingProblem {
    public static void main(String[] args) {
        System.out.println("Task 9: Coin Changing Problem");

        int[] denominations = new int[] {1, 2, 5};
        int amount = 7;
        int result = solveCoinChange(denominations, amount);
        System.out.print("SolveCoinChange(" + Arrays.toString(denominations) +  ", " + amount + ") = ");
        System.out.print(result);
    }

    private static int solveCoinChange(int[] denominations, int amount) {
        int[] solution = new int[amount + 1];
        solution[0] = 1;

        for (int den: denominations){
            for (int i = den; i < solution.length; i++) {
                solution[i] += solution[i - den];
            }
        }

        return solution[solution.length-1];
    }
}
