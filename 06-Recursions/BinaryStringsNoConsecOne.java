import java.util.*;

public class BinaryStringsNoConsecOne {

    //  IF USING STRINGBUILDER — THERE IS A CATCH:
    // StringBuilder is MUTABLE, so appending modifies the current object.
    // Hence, we create new StringBuilder objects (str0 and str1) for each recursive branch.

    //  Recursive function to generate binary strings of size 'n' without consecutive 1s
    public static void generate(int n, StringBuilder str, int lastDigit) {
        //  Base case: if n becomes 0, print the current string
        if (n == 0) {
            System.out.println(str);
            return;
        }

        //  You can always add '0'
        StringBuilder str0 = new StringBuilder(str);
        str0.append("0");
        generate(n - 1, str0, 0);

        //  Add '1' only if last digit was not '1'
        if (lastDigit == 0) {
            StringBuilder str1 = new StringBuilder(str);
            str1.append("1");
            generate(n - 1, str1, 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();

        System.out.println("Binary strings of size " + n + " without consecutive 1s:");
        generate(n, new StringBuilder(), 0); // start with empty string and lastDigit = 0

        sc.close();
    }
}
