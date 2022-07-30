package io.github.kamil_jankowski.task15;

public class Rotated {
    public static void main(String[] args) {
        System.out.println("Task 15: Search Rotated Array");

        int[] testArray = new int[]{1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162, 176, 188, 199, 200, 210, 222};
        int[] rotatedArray = new int[]{176, 188, 199, 200, 210, 222, 1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162};

        System.out.println("Number 210 found: " + binarySearch(testArray, 210));
        System.out.println("Number 155 found: " + binarySearchRotated(rotatedArray, 155));
        System.out.println("Number 210 found: " + binarySearchRotated(rotatedArray, 210));
        System.out.println("Number 200 found: " + binarySearchRotated(rotatedArray, 200));
        System.out.println("Number 211 found: " + binarySearch(testArray, 211));
    }

    static int binarySearch(int[] arr, int key){
        int lowBound = 0;
        int highBound = arr.length - 1;

        while (lowBound <= highBound){
            int mid = lowBound + (highBound - lowBound)/2;

            if (arr[mid] < key) {           // key value possible in upper half
                lowBound = mid + 1;
            } else if (arr[mid] > key){     // key value possible in lower half
                highBound = mid - 1;
            } else {
                // arr[mid] == key
                return mid;
            }
        }
        return -1; // index for given value not found
    }

    static int binarySearchRotated(int[] arr, int key){
        int lowBound = 0;
        int highBound = arr.length - 1;

        while (lowBound <= highBound){
            int mid = lowBound + (highBound - lowBound)/2;

            if (arr[mid] == key) return mid;
            if (arr[mid] < key){
                if (arr[highBound] >= key) {            // key value possible in unrotated upper half
                    lowBound = mid + 1;
                } else {                                // key value possible in rotated lower half
                    highBound = mid - 1;
                }
            } else if (arr[mid] > key){
                if (arr[lowBound] <= key) {             // key value possible in unrotated lower half
                    highBound = mid - 1;
                } else {                                // key value possible in rotated upper half
                    lowBound = mid + 1;
                }
            }
        }
        return -1; // index for given value not found
    }
}
