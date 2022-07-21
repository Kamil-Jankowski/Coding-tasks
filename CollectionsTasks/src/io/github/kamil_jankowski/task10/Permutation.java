package io.github.kamil_jankowski.task10;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        System.out.println("Task 10: Find Kth Permutation");
        int numberOfElements = 3;
        for (int k = 1; k <= factorial(numberOfElements); k++) {
            System.out.println("Permutation number " + k + " = \t" + get_permutation(numberOfElements, k));
        }

        numberOfElements = 2;
        for (int k = 1; k <= factorial(numberOfElements); k++) {
            System.out.println("Permutation number " + k + " = \t" + get_permutation(numberOfElements, k));
        }
    }

    static String get_permutation(int n, int k) {
        List<Character> elements = new ArrayList<>();
        char c = '1';
        for (int i = 1; i <= n; ++i) {
            elements.add(c);
            c++;
        }

        StringBuilder result = new StringBuilder();
        find_kth_permutation(elements, k, result);
        return result.toString();
    }

    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    static void find_kth_permutation(List<Character> elements, int k, StringBuilder result) {
        if (elements.isEmpty()) return;
        int n = elements.size();   // amount of elements left in the list

        // count is a number of permutations in which each element is taking first position in a permutation (index = 0)
        int count = factorial(n - 1);
        int index = (k-1)/count;              // making k zero-based

        result.append(elements.get(index));
        elements.remove(index);

        k = k - (count * index);
        find_kth_permutation(elements, k, result);
    }

}