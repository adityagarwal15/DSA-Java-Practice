import java.util.*;

public class LargestNum {

    public static int getLargest(int numbers[]) {
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (largest < numbers[i]) {
                largest = numbers[i];
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        int numbers[] = {2, 3, 4, 5, 6};
        int result = getLargest(numbers);
        System.out.println("Largest number is: " + result);
    }
}
