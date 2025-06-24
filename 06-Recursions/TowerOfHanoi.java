import java.util.*;

public class TowerOfHanoi {

    // Recursive function to move 'n' disks from source to destination using auxiliary rod
    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
        // Base case: if only 1 disk, just move it
        if (n == 1) {
            System.out.println("Shift disk 1 from '" + source + "' to '" + destination + "'");
            return;
        }

        // Step 1: Move top n-1 disks from source to auxiliary using destination as helper
        solveHanoi(n - 1, source, destination, auxiliary);

        // Step 2: Move the nth (largest) disk from source to destination
        System.out.println("Shift disk " + n + " from '" + source + "' to '" + destination + "'");

        // Step 3: Move the n-1 disks from auxiliary to destination using source as helper
        solveHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disks (N): ");
        int n = sc.nextInt();

        System.out.println("\nSteps to solve Tower of Hanoi with " + n + " disks:");
        solveHanoi(n, 'A', 'B', 'C');  // A = source, B = auxiliary, C = destination

        sc.close();
    }
}
