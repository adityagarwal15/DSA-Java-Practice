public class MaxSubArraySumPrefix {

    public static void PrefixSum(int numbers[]) {
        int n = numbers.length;
        int PrefixArr[] = new int[n];

        // Step 1: Create prefix sum array
        PrefixArr[0] = numbers[0];  // for the case indices 0 
        for (int i = 1; i < n; i++) {
            PrefixArr[i] = PrefixArr[i - 1] + numbers[i];
        }

        // Step 2: Find max subarray sum using prefix sums
        int maxSum = Integer.MIN_VALUE;  // - infinity

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int PrefixSumRes;  // calculating sum 
                if (i == 0) {
                    PrefixSumRes = PrefixArr[j];
                } else {
                    PrefixSumRes = PrefixArr[j] - PrefixArr[i - 1];
                }

                //
                System.out.println("Subarray (" + i + ", " + j + ") sum = " + PrefixSumRes);
                
                //comparing prefixSum with the maxSum to get MaxSum
                maxSum = Math.max(maxSum, PrefixSumRes); // max sum
            }
        }

        System.out.println("Maximum Subarray Sum is: " + maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = {1, -2, 6, -1, 3};
        PrefixSum(numbers);
    }
}
