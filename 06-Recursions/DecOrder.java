public class DecOrder {

    public static void dec(int n) {
        // Base case
        if (n == 1) {
            System.out.print(n);  // No space after last number
            return;
        }

        System.out.print(n + " ");
        dec(n - 1);  // Recursive call
    }

    public static void main(String[] args) {
        int n = 10;
        dec(n);  // Call the method
    }
}
