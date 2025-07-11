public class LexicographicallySmallestString {

    public static String smallestString(int N, int K) {
        char[] result = new char[N];

        // Step 1: Fill the entire result array with 'a'
        // This gives us the lexicographically smallest base string
        // Since 'a' = 1, the total value so far is N * 1 = N
        for (int i = 0; i < N; i++) {
            result[i] = 'a';
        }

        // Step 2: Calculate how much more value we need to reach sum K
        int remaining = K - N;

        /* 
         Lexicographically Smallest Strategy:
         - Smaller characters should stay on the left
         - So we only upgrade characters from the right side
         - This ensures the left side remains as 'a' as much as possible
        */

        // Step 3: Start upgrading characters from the end
        int index = N - 1;
        while (remaining > 0 && index >= 0) {
            // The max you can add to 'a' is 25 ('a' + 25 = 'z')
            int add = Math.min(25, remaining);

            // Upgrade the character at the current index
            result[index] = (char) (result[index] + add);

            // Subtract the value we've just added
            remaining -= add;

            // Move to the previous character
            index--;
        }

        // Convert the character array to a string and return
        return new String(result);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(smallestString(5, 42)); // Output: aamz
        System.out.println(smallestString(3, 25)); // Output: aaw
    }
}
