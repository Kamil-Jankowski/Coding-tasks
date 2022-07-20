package io.github.kamil_jankowski.demoTest.task2;

import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'numberOfItems' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY startIndices
     *  3. INTEGER_ARRAY endIndices
     *
     * Sample input:
     * "*|**|*|*|****" or "|**|*|*"
     * 2
     *
     * 1
     * 1
     * 5
     * 6
     */

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> numberOfItems = new ArrayList<>();
        // TODO: additionally, it would be good to verify which list is shorter, to avoid receiving index out of bound ex.
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < startIndices.size(); i++){
            // create substring for a given pair of indices
            final String substring = sb.substring(startIndices.get(i), endIndices.get(i));
            // count the amount of items in closed compartments
            int counter = 0;

            int start = 0;
            for(int j = 0; j < substring.length(); j++){
                /*If | is noticed, count items.*/
                if(substring.charAt(j) == '|'){
                    counter += countItems(substring, start, j-1);
                    start = j+1;  // Defines new starting point
                }
            }
            numberOfItems.add(counter);
        }
        System.out.println(numberOfItems);
        return numberOfItems;
    }

    private static int countItems(String string, int start, int end) {
        int counter = 0;
        System.out.println("Counting items in: " + string);
        System.out.println("Specifically in: " + string.substring(start, end+1));
        for (int i = start; i <= end; i++){
            if (string.charAt(i) == '*') counter++;
            System.out.println(string.charAt(i));
        }
        return counter;
    }

}