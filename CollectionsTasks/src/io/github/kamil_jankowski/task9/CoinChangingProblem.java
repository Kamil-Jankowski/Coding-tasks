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

    /* Dynamic Programming Java implementation of Coin Change problem */
    private static int solveCoinChange(int[] denominations, int amount) {
        /*
         Time complexity of this function: O(mn)
         Space Complexity of this function: O(n)

         solution[i] will be storing the number of solutions
         for amount i. We need n+1 rows as the table is
         constructed in bottom up manner using the base
         case (n = 0)
        */
        int[] solution = new int[amount + 1];

        /*
         Base case (If given value i is 0)
        */
        solution[0] = 1;

        /*
         Check how many possibilities each denomination gives to gather required amount.
         Passes through each denomination one by one, adding to previously calculated possibilities from other denominations,
         and the current one.
        */
        for (int den: denominations){
            System.out.println("Denomination: " + den);
            for (int i = den; i < solution.length; i++) {
                solution[i] += solution[i - den];
                System.out.println("Index " + i + " = " + solution[i]);
            }
        }
        System.out.println(Arrays.toString(solution));
        return solution[solution.length-1];
    }
}
