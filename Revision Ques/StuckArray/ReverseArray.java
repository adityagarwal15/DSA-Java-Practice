package StuckArray;
import java.util.*;

public class ReverseArray {

    // Method that reverses the array in-place and returns it
    public static int[] reverse(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr; // return the modified array
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // enter the length of the array
        System.out.print("Enter the length of an array: ");
        int len = sc.nextInt();

        // initialize and input the array
        int arr[] = new int[len];
        System.out.print("Enter elements in the array: ");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        // call reverse and store the result
        int[] reversedArr = reverse(arr);

        // now print in main, not inside the method ( USING FOR-EACH LOOP)
        // System.out.print("Reversed array: ");
        // for (int num : reversedArr) {
        //     System.out.print(num + " ");
        // }

        // PRINTING USING (NORMAL FOR LOOP)
        System.out.print("Reversed array: ");
            for (int i = 0; i < reversedArr.length; i++) {
            System.out.print(reversedArr[i] + " ");
        }


        sc.close();
    }
}
