import java.util.*;

public class PrintChar {

    // Method to print characters of the string one by one
    public static void printLetters(String fullName){
        for (int i = 0; i < fullName.length(); i++) {
            // Looping through each character of the string
            System.out.print(fullName.charAt(i) + " "); // Print character at index i
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input full name using nextLine() to allow spaces
        System.out.print("Enter fullname: ");
        String fullName = sc.nextLine();

        // Function call to print each character
        printLetters(fullName);

        sc.close();
    }
}
