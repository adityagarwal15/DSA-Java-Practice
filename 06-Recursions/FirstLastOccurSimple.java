import java.util.*;

public class FirstLastOccurSimple {

    public static int firstOccurrence(int[] arr, int index, int key) {
        if (index == arr.length) return -1; // if index = size of an array then -1
        if (arr[index] == key) return index;
        return firstOccurrence(arr, index + 1, key);
    }

    public static int lastOccurrence(int[] arr, int index, int key) {
        if (index < 0) return -1; // if index is less than 0 then -1
        if (arr[index] == key) return index;
        return lastOccurrence(arr, index - 1, key); //-1 because we are check from the last
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("enter size of an array: ");
        int size = sc.nextInt();

        System.out.print("enter array: ");
        int arr[] = new int[size];

        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
       
        System.out.print("enter key: ");
        int key = sc.nextInt();

        int first = firstOccurrence(arr, 0, key); //index = 0
        int last = lastOccurrence(arr, arr.length - 1, key); //index = last

        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
    }
}
