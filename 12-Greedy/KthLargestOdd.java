public class KthLargestOdd {

    public static int findKthLargestOdd(int L, int R, int K) {

        //SINCE IT IS AN RANGE, THEY ARE ALREADY SORTED

        // Step 1: Find max odd <= R
        int maxOdd = (R % 2 == 1) ? R : R - 1; 

        // Step 2: Find min odd >= L
        int minOdd = (L % 2 == 1) ? L : L + 1;  

        // Step 3: Count total odd numbers in range
        int totalOdds = ((maxOdd - minOdd) / 2) + 1;

        // Step 4: Check if K is valid
        if (K > totalOdds) {
            return 0;
        }

        // Step 5: Return Kth largest odd
        return maxOdd - 2 * (K - 1);
    }

    public static void main(String[] args) {
        int L = -3;
        int R = 3;
        int K = 1;

        int result = findKthLargestOdd(L, R, K);
        System.out.println("Kth largest odd number = " + result);
    }
}
