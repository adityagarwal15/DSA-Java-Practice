import java.util.*;

public class AnagramCheck {

    // Method to check if two strings are anagrams
    public static boolean check(String str1, String str2) {

        // 🔹 Step 1: Remove leading/trailing spaces
        str1 = str1.trim();
        str2 = str2.trim();

        // 🔹 Step 2: Convert to lowercase (case-insensitive check)
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 🔹 Step 3: Check if lengths are equal
        if (str1.length() != str2.length()) {
            return false; // different lengths can't be anagrams
        }

        // 🔹 Step 4: Convert strings to character arrays
        char arr1[] = str1.toCharArray();
        char arr2[] = str2.toCharArray();

        // 🔹 Step 5: Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // 🔹 Step 6: Compare sorted arrays
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 🔸 Input both strings
        System.out.print("Enter string 1: ");
        String str1 = sc.nextLine();

        System.out.print("Enter string 2: ");
        String str2 = sc.nextLine();

        // 🔸 Output result
        if (check(str1, str2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are NOT anagrams.");
        }
    }
}
