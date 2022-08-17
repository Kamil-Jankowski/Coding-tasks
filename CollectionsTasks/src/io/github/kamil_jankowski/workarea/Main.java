package io.github.kamil_jankowski.workarea;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Work-area");

        int n = 5;
        int minimum = (int) (Math.ceil(Math.log(n+1)/Math.log(2)) - 1);

        SortedSet<String> set = new TreeSet<>();
        System.out.println(minimum);

        Stack<String> stack = new Stack<>();
        stack.add("!");
        stack.add("World");
        stack.add("Hello");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
