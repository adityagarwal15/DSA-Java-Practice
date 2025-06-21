import java.util.*;

public class SumNnatural {

    public static int Nat(int n) {
        if (n == 1) {
            return 1; // base case because sum of 1 natural number will be 1 only
        }
        return n + Nat(n - 1); // recursive case till it hits base case and then sums while unwinding the call stack
    }
    
    //another approach
   public static int Natural(int count, int n) {
    if (count > n) {
        return 0; // base case: if current number exceeds n, stop and return 0
    }
    return count + Natural(count + 1, n); // recursive case: add current count and go to next
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num to get sum of natural numbers: ");
        int num = sc.nextInt();

        int result = Nat(num);
        System.out.println("Sum of first " + num + " natural numbers is: " + result);

       int res = Natural(1, num);  // pass count=1, n=num
       System.out.println("Sum using second approach: " + res);

       sc.close();
    }
}
