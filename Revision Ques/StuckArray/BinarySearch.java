package StuckArray;
import java.util.*;

public class BinarySearch {

    public static int Search(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {  //means the key is at 2nd half
                start = mid + 1;  //moving the start pointer to mid+1 and keeping end at last only
            } else {  //means the key is at 1st half
                end = mid - 1;  //moving the end pointer to mid-1 and keeping start at 0
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // enter the length of an array
        System.out.print("Enter length of array: ");
        int len = sc.nextInt();

        if (len <= 0) {
            System.out.println("Invalid length... exiting!");
            sc.close();
            return;
        }

        // initialize and input a sorted array
        int arr[] = new int[len];
        System.out.println("Enter " + len + " sorted elements:");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        // enter the key to find
        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        int result = Search(arr, key);

        if (result == -1) {
            System.out.println("Key not found.");
        } else {
            System.out.println("Key found at index: " + result);
        }

        sc.close();
    }
}
