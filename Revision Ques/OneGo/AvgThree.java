package OneGo;
import java.util.*;

public class AvgThree {

    public static void Avg(int a, int b, int c) {

        // use of brackets is important
        int avg = (a + b + c) / 3;
        System.out.println("Average of the three numbers (" + a + ", " + b + ", " + c + ") is: " + avg);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        int a = sc.nextInt();

        System.out.print("Enter number 2: ");
        int b = sc.nextInt();

        System.out.print("Enter number 3: ");
        int c = sc.nextInt();

        Avg(a, b, c);

        sc.close();  // good practice
    }
}
