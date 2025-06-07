public class StringCompression {

    public static String compress(String str) {
        StringBuilder sb = new StringBuilder();

        int n = str.length();
        for (int i = 0; i < n; i++) {
            int count = 1; // current character is already counted

            // count consecutive repeating characters
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            sb.append(str.charAt(i)); // add the character

            if (count > 1) {
                sb.append(count); // add the count (if more than 1)
            }
        }

        return sb.toString(); // return as String
    }

    public static void main(String[] args) {
        String str = "aaabbcccdd";
        System.out.print(compress(str)); // Output: a3b2c3d2
    }
}
