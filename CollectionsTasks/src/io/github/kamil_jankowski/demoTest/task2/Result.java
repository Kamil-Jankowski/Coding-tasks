package io.github.kamil_jankowski.demoTest.task2;

import java.util.ArrayList;
import java.util.List;

class Result {
    public static final String BORDER = "|";

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
     * 2 -> amount of starting indices
     * 1 -> start index
     * 1 -> start index
     * 2 -> amount of end indices
     * 5 -> end index
     * 6 -> end index
     */

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> numberOfItems = new ArrayList<>();

        if (s == null) return numberOfItems;

        arrayEqualizer(s, startIndices, endIndices);

        for (int i = 0; i < startIndices.size(); i++) {
            final int items;
            if (startIndices.get(i) < 0 || endIndices.get(i) > s.length() - 1){
                System.out.println("Given borders are out of bounds");
                items = 0;
            } else {
                items = countItems(s, startIndices, endIndices, i);
            }
            numberOfItems.add(items);
        }
        System.out.println("Number of items found for given indices pairs: " + numberOfItems);
        return numberOfItems;
    }

    private static void arrayEqualizer(String s, List<Integer> startIndices, List<Integer> endIndices) {
        int startIndex = 0;
        int endIndex = s.length()-1;
        final int startSize = startIndices.size();
        final int endSize = endIndices.size();

        if (startSize > endSize){
            for (int i = 0; i < startSize - endSize; i++){
                endIndices.add(endIndex);
            }
        }

        if (startSize < endSize){
            for (int i = 0; i < endSize - startSize; i++){
                startIndices.add(startIndex);
            }
        }
    }

    private static int countItems(String s, List<Integer> startIndices, List<Integer> endIndices, int i) {
        String range = s.substring(startIndices.get(i), endIndices.get(i)+1);

        int openingIndex = range.indexOf(BORDER);
        int closingIndex = range.lastIndexOf(BORDER);
        String closedRange = range.substring(openingIndex, closingIndex);
        final String items = closedRange.replaceAll("\\|", "");

        System.out.println("Range to be examined: " + range);
        System.out.println("Closed range of items: " + closedRange);
        System.out.println("Just enclosed items: " + items);

        return items.length();
    }

}