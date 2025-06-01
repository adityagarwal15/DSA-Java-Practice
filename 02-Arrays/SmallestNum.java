import java.util.*;

public class SmallestNum {

    public static int getSmallest(int numbers[]) {
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (smallest > numbers[i]) {
                smallest = numbers[i];
            }
        }

        return smallest;
    }

    public static void main(String[] args) {
        int numbers[] = {2, 3, 4, 5, 6};
        int result = getSmallest(numbers);
        System.out.println("smallest number is: " + result);
    }
}
