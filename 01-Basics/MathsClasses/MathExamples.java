package MathsClasses;
import java.util.*;

public class MathExamples {

    public static void main(String[] args) {
        // Math.min()
        System.out.println("Math.min(10, 20): " + Math.min(10, 20));  // 10

        // Math.max()
        System.out.println("Math.max(10, 20): " + Math.max(10, 20));  // 20

        // Math.sqrt()
        System.out.println("Math.sqrt(16): " + Math.sqrt(16));  // 4.0

        // Math.pow()
        System.out.println("Math.pow(2, 3): " + Math.pow(2, 3));  // 8.0

        // Average calculation (no Math.avg())
        int a = 10, b = 20;
        double avg = (a + b) / 2.0;
        System.out.println("Average of 10 and 20: " + avg);  // 15.0

        // Math.abs()
        System.out.println("Math.abs(-10): " + Math.abs(-10));  // 10
    }
}
