package io.github.kamil_jankowski.task7;

import java.util.HashSet;
import java.util.Set;

public class StringSegmentation {
    public static void main(String[] args) {
        System.out.println("Task 7: String segmentation\n");

        Set<String> dictionary = new HashSet<>();
        String segmantable = "hellonow";
        String nonSegmantable = "HellowThere";

        dictionary.add("hello");
        dictionary.add("hell");
        dictionary.add("on");
        dictionary.add("now");

        if (canSegmentString(segmantable, dictionary)) {
            System.out.println("String can be segmented");
        } else {
            System.out.println("String can NOT be segmented");
        }

        if (canSegmentString(nonSegmantable, dictionary)) {
            System.out.println("String can be segmented");
        } else {
            System.out.println("String can NOT be segmented");
        }
    }

    private static boolean canSegmentString(String stringToVerify, Set<String> dictionary) {
        return false;
    }
}
