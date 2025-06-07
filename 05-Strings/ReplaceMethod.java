public class ReplaceMethod {
    public static void main(String args[]) {
        String str = "The matter";
        
        // Removes all lowercase 't'
        String result = str.replace("t", "");

        // Removes both lowercase and uppercase 't' and 'T' using regex
        String result2 = str.replaceAll("[tT]", "");

        System.out.println(str);     // Original string
        System.out.println(result);  // After removing only lowercase 't'
        System.out.print(result2);   // After removing both 't' and 'T'
    }
}
