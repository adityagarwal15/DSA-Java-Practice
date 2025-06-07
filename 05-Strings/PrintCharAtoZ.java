public class PrintCharAtoZ {
    public static void main(String[] args) {

        // Approach 1: Using only StringBuilder 'sb'
        StringBuilder sb = new StringBuilder("");

        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);  // Appending characters a to z
        }

        System.out.println("Using sb only: " + sb.toString());  // Output: abc...z

        /*
        // Approach 2: Using both sb and result
        
        StringBuilder sb = new StringBuilder("");
        StringBuilder result = null;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            result = sb.append(ch);  // result also refers to sb
        }

        System.out.println("Using result: " + result.toString());
        */
    }
}
