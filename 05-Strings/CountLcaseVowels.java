import java.util.*;

public class CountLcaseVowels {

    // Method to count lowercase vowels in a given string
    public static String count(String str) {
        StringBuilder sb = new StringBuilder();  
        int count = 0;                           
        int n = str.length();                    

        for (int i = 0; i < n; i++) {

             char ch = (str.charAt(i));  // store current char into ch

            // char ch = Character.toLowerCase(str.charAt(i));  // always convert current char to lowercase

            // comapre ch if it's a lowercase vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {

                //ch == 'a' and ch == 'A' both are different

                count++;  // Increase count if it's a vowel
            }
        }

        sb.append(count);  // stringbuilder automatically convert count(int) to string
        return sb.toString(); // Convert StringBuilder to String and return
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);     
        System.out.print("Enter string: ");
        String str = sc.nextLine();              

        String result = count(str);             
        System.out.println("Vowel count: " + result);  
    }
}



