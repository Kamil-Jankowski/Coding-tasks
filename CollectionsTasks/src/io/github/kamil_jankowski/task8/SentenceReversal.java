package io.github.kamil_jankowski.task8;

public class SentenceReversal {

    public static final String EMPTY_SPACE = " ";

    public static void main(String[] args) {
        System.out.println("Task 8: Reverse words in a sentence");

        System.out.println(reverseSentence("Hello World!"));
        System.out.println(reverseSentence("We love Java"));
        System.out.println(reverseSentence("To be, or not to be?"));
    }

    private static String reverseSentence(String sentence){
        StringBuilder sb = new StringBuilder();
        final String[] splitString = sentence.split("\\W+");
        final int length = splitString.length;
        for (int i = length-1; i >= 0; i--){
            sb.append(splitString[i]).append(EMPTY_SPACE);
        }
        return sb.toString();
    }
}
