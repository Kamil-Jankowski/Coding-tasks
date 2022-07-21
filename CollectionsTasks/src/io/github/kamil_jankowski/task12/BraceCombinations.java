package io.github.kamil_jankowski.task12;

import java.util.ArrayList;

public class BraceCombinations {
    public static void main(String[] args) {
        System.out.println("Task 12: Print balanced brace combinations");

        print(findAllBracesCombinations(2));
        print(findAllBracesCombinations(3));
    }

    private static ArrayList<String> findAllBracesCombinations(int bracesPairs) {
        ArrayList<String> results = new ArrayList<>();
        findAllBracesCombinations(bracesPairs, 0, 0, "", results);
        return results;
    }

    private static void findAllBracesCombinations(int bracePairs, int leftBraces, int rightBraces, String output, ArrayList<String> results)
    {
        /*
         If the count of both left and right braces reaches bracePairs amount, it means we have generated a valid pairs.
         So, we add the currently generated output string to the final results list and end recursion.
        */
        if (leftBraces == bracePairs && rightBraces == bracePairs) {
            results.add(output);
            return;
        }

        /*
         We can add a left brace only if its current count is less than amount of brace pairs.
        */
        if (leftBraces < bracePairs) {
            findAllBracesCombinations(bracePairs, leftBraces + 1, rightBraces, output + "{",
                    results);
        }

        /*
         We can add a right brace only if its current count is less than amount of left braces.
        */
        if (rightBraces < leftBraces) {
            findAllBracesCombinations(bracePairs, leftBraces, rightBraces + 1, output + "}",
                    results);
        }
    }

    private static void print(ArrayList<String> results) {
        results.forEach(System.out::println);
    }
}
