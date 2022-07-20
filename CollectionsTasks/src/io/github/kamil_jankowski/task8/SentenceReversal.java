package io.github.kamil_jankowski.task8;

class SentenceReversal {

    private static final String EMPTY_SPACE = " ";

    public static void main(String[] args) {
        System.out.println("Task 8: Reverse words in a sentence");

        System.out.println(reverseSentence("Hello World!"));
        System.out.println(reverseSentence("We love Java"));
        System.out.println(reverseSentence("To be, or not to be?"));

        final char[] sentence = "Hello World".toCharArray();
        System.out.println(reverseSentence(sentence));
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

    private static void reverse(char[] sentence, int start, int end) {
        /*Performing in-place reversal of given array*/
        while (start <= end) {
            char tmp = sentence[start];
            sentence[start] = sentence[end];
            sentence[end] = tmp;

            start++;
            end--;
        }
    }

    private static char[] reverseSentence(char[] sentence){
        int start = 0;
        for(int i = 0; i < sentence.length; i++){
            /*If empty space is noticed, reverse previously iterated word.*/
            if(sentence[i] == ' '){
                reverse(sentence, start, i-1);
                start = i+1;  // Defines new starting point for next reversal.
            }
        }
        /*Reversing the last word in an array, since it does not end with an empty space.*/
        reverse(sentence, start, sentence.length-1);

        /*Reverse the complete sentence*/
        reverse(sentence, 0, sentence.length-1);

        return sentence;
    }
}
