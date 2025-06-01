
import java.util.*;

public class LinearSearch {

    public static int Linear(int numbers[], int key){
        
        for (int i = 0; i<numbers.length; i++){
            if(numbers[i] == key){
                return i;
            }
        }
        return -1; //if key not found
    }

    public static void main(String[] args){
        int numbers[] = {1,2,3,4,5,6,7,8,9,10};
        int key = 7;

        int result = Linear(numbers,key);
        System.out.print("key found at index: " + result);


    }
}
