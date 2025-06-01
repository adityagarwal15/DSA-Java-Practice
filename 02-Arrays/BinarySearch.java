import java.util.*;

public class BinarySearch {

    public static int Binary(int numbers[], int key) {
        int start = 0;
        int end = numbers.length - 1; //because to get last position it follow 0-based indexing so last index will length - 1

        while (start <= end) {   //to check all numbers
            int mid = (start + end) / 2;

            if (numbers[mid] == key) {    // Compare value at mid
                return mid; // returns an index at which key is found
            } else if (numbers[mid] < key) { // go right
                start = mid + 1;
            } else {  // go left
                end = mid - 1;
            }
        }

        return -1;  // not found
    }

    public static void main(String[] args) {
        int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 8;

        int result = Binary(numbers, key);

        if (result == -1) {
            System.out.println("Key not found.");
        } else {
            System.out.println("Key is found at index: " + result);
        }
    }
}
