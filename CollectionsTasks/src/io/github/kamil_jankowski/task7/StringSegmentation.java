package io.github.kamil_jankowski.task7;

import java.util.HashSet;
import java.util.Set;

public class StringSegmentation {
    public static void main(String[] args) {
        System.out.println("Task 7: String segmentation\n");

        Set<String> dictionary = new HashSet<>();
        String segmantable = "hellonow";
        String nonSegmantable = "HelloThere";
        String segmantable2 = "piepi";

        dictionary.add("apple");
        dictionary.add("pear");
        dictionary.add("pier");
        dictionary.add("pie");

        dictionary.add("hello");
        dictionary.add("hell");
        dictionary.add("on");
        dictionary.add("now");

        printResultOf(dictionary, segmantable);
        printResultOf(dictionary, nonSegmantable);
        printResultOf(dictionary, segmantable2);
    }

    private static void printResultOf(Set<String> dictionary, String string) {
        if (canSegmentString(string, dictionary)) {
            System.out.printf("String %s can be segmented.%n", string);
        } else {
            System.out.printf("String %s can NOT be segmented.%n", string);
        }
    }

    static Set<String> verifiedSegmentsFalse = new HashSet<>();

    private static boolean canSegmentString(String stringToVerify, Set<String> dictionary) {
        boolean isSegmentable = false;
        if(verifiedSegmentsFalse.contains(stringToVerify.toLowerCase())) return false;
        for (int i = 0; i < stringToVerify.length(); i++) {
            String firstString = stringToVerify.substring(0, i+1);
            String secondString = stringToVerify.substring(i+1);
            if (dictionary.contains(firstString.toLowerCase())) {
                if (dictionary.contains(secondString.toLowerCase()) || secondString.length() == 0) {
                    return true;
                } else {
                    if(!verifiedSegmentsFalse.contains(secondString.toLowerCase())) {
                        isSegmentable = canSegmentString(secondString, dictionary);
                    }
                    if (!isSegmentable) verifiedSegmentsFalse.add(secondString.toLowerCase());
                }
            } else {
                verifiedSegmentsFalse.add(firstString.toLowerCase());
            }
        }
        return isSegmentable;
    }
}
