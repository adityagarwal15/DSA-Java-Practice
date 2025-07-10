public class MaxBalancedStrings {

    public static int countBalancedSubstrings(String str) {
        int balance = 0;
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            // Increase for L, decrease for R
            if (str.charAt(i) == 'L') {
                balance++;
            } else if (str.charAt(i) == 'R') {
                balance--;
            }

            // If balance becomes 0, we've found a balanced substring
            if (balance == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        int result = countBalancedSubstrings(str);
        System.out.println("Maximum number of balanced substrings = " + result);
    }
}
