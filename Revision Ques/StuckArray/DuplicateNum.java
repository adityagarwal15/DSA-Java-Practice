package StuckArray;
import java.util.*;

public class DuplicateNum {

    public static boolean checkDuplicate(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true; // Duplicate found
                }
            }
        }
        return false; // No duplicates found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Enter len of an array
        System.out.print("Enter length of an array: ");
        int len = sc.nextInt();

        // Initialize and input an array
        int arr[] = new int[len];
        System.out.println("Enter " + len + " elements in the array: ");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        if (checkDuplicate(arr)) {
            System.out.println("It has duplicate elements.");
        } else {
            System.out.println("It doesn't have duplicates.");
        }

        sc.close();
    }
}
