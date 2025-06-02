public class MaxSubArraySum {

    public static void SubArr(int numbers[]) {
        int count = 0; // to count the total number of subarrays
        int maxSubarraySum = Integer.MIN_VALUE; // to track the maximum subarray sum

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                int sum = 0;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    System.out.print(numbers[k] + " ");
                    sum += numbers[k];
                    max = Math.max(max, numbers[k]);
                    min = Math.min(min, numbers[k]);
                }

                // Update the maxSubarraySum if current subarray's sum is greater
                maxSubarraySum = Math.max(maxSubarraySum, sum);

                System.out.println("| Sum: " + sum + ", Max: " + max + ", Min: " + min);
                count++;
            }
            System.out.println();
        }

        System.out.println("The total number of subarrays are: " + count);
        System.out.println("Maximum subarray sum is: " + maxSubarraySum);
    }

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10};
        SubArr(numbers);
    }
}


