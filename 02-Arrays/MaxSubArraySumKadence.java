public class MaxSubArraySumKadence {

    public static void Kadence(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            currSum += numbers[i];                       // add current element to currSum
            maxSum = Math.max(maxSum, currSum);          // update maxSum if needed

            if (currSum < 0) {
                currSum = 0;                              // reset currSum if it's negative
            }
             System.out.print(currSum + " ");
        }
       
        System.out.println("Max subarray sum is: " + maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        Kadence(numbers);
    }
}
