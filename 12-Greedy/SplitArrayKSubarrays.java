public class SplitArrayKSubarrays {

    // Function to count how many subarrays are needed if max allowed sum is 'maxSumAllowed'
    public static int countSubarrays(int[] arr, int maxSumAllowed) {
        int count = 1;  // at least 1 subarray
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            // If adding this element exceeds allowed sum, start a new subarray
            if (currentSum + arr[i] > maxSumAllowed) {
                count++;              // new subarray
                currentSum = arr[i];  // start new sum
            } else {
                currentSum += arr[i]; // add to current subarray
            }
        }

        return count; // total subarrays formed
    }

    // Function to find the minimized maximum subarray sum when splitting into K parts
    public static int splitArray(int[] arr, int K) {
        int low = 0, high = 0;

        // Step 1: Set initial binary search bounds
        for (int i = 0; i < arr.length; i++) {
            low = Math.max(low, arr[i]); // at least one element per subarray
            high += arr[i];              // max can be total sum (if one subarray)
        }

        int answer = high;

        // Step 2: Binary Search
        while (low <= high) {
            int mid = (low + high) / 2;

            // Count how many subarrays needed if max subarray sum is 'mid'
            int numSubarrays = countSubarrays(arr, mid);

            if (numSubarrays <= K) {
                // We can try smaller sum (minimize further)
                answer = mid;
                high = mid - 1;
            } else {
                // We need more subarrays → increase allowed sum
                low = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2};
        int K1 = 2;

        int[] arr2 = {1, 2, 3, 4};
        int K2 = 3;

        System.out.println("Minimum max subarray sum: " + splitArray(arr1, K1)); // Output: 2
        System.out.println("Minimum max subarray sum: " + splitArray(arr2, K2)); // Output: 4
    }
}
