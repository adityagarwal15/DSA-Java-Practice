import java.util.*;

public class TwoProductInput {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int prod = a * b;

        sc.close();
        System.out.println(prod);
    }
}
