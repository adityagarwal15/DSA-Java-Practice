public class Palindrome {
    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "racecar";
        if (isPalindrome(str)) {
            System.out.println("It is a palindrome!");
        } else {
            System.out.println("It is not a palindrome.");
        }
    }
}
