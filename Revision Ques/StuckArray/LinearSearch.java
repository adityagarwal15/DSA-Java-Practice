package StuckArray;
import java.util.*;

public class LinearSearch {

    public static int Search(int arr[], int key){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key){
                return i;  // returns the index at which key is found
            }
        }
        return -1; // if key is not found
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Length of the array
        System.out.print("Enter length of the array: ");
        int len = sc.nextInt();

        // Initialize the array

        //this is how we initalize the array, remember
        int arr[] = new int[len];

        // Input array elements
        System.out.println("Enter elements of the array:");
        for(int i = 0; i < len; i++){
            arr[i] = sc.nextInt();
        }

        // Enter key
        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        int result = Search(arr, key);
        
        if(result == -1){
            System.out.println("Key not found.");
        } else {
            System.out.println("Key is found at index: " + result);
        }

        sc.close();
    }
}
