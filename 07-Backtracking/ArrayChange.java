import java.util.*;

public class ArrayChange {

public static void change(int arr[], int i, int val){
    if(i == arr.length){
        System.out.println("Array before backtracking: " + Arrays.toString(arr));
        return;
    }
    arr[i] = val;
    change(arr, i + 1, val + 1);
    arr[i] = arr[i] - 2;  // backtracking
}

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int arr[] = new int[size];
        System.out.print("Enter elements in array: ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        change(arr, 0, 1);

        System.out.println("Final array after recursion and backtracking:");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
