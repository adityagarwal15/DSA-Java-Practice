import java.util.*;

public class GenerateBinaryNumbers {

    public static void generateBinary(int N) {
        Queue<String> q = new LinkedList<>();
        q.offer("1"); // Start with "1"

        for (int i = 1; i <= N; i++) {
            String front = q.poll();    // Get the front binary string
            System.out.print(front + " "); // Print it

            // Add next two binary strings
            q.offer(front + "0");
            q.offer(front + "1");
        }
    }

    public static void main(String[] args) {
        int N1 = 2;
        int N2 = 5;

        System.out.print("Binary numbers from 1 to " + N1 + ": ");
        generateBinary(N1);
        System.out.println();

        System.out.print("Binary numbers from 1 to " + N2 + ": ");
        generateBinary(N2);
        System.out.println();
    }
}
