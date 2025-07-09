import java.util.*;

public class FirstNonRepeatingCharStream {

    public static void firstNonRepeating(String stream) {
        Queue<Character> q = new LinkedList<>();
        int[] freq = new int[26]; // for 'a' to 'z'

        for (int i = 0; i < stream.length(); i++) {
            char ch = stream.charAt(i);

            // Step 1: Add character to queue
            q.offer(ch);

            // Step 2: Increase frequency
            freq[ch - 'a']++;

            // Step 3: Remove all repeating characters from front
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            // Step 4: Print result
            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void main(String[] args) {
        String stream = "aabcbd";
        System.out.println("Stream: " + stream);
        System.out.print("Output: ");
        firstNonRepeating(stream);
    }
}
