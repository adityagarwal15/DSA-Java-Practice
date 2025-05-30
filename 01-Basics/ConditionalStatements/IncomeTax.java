package ConditionalStatements;
import java.util.*;

public class IncomeTax {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your salary: ");
        double salary = sc.nextDouble();

        if (salary <= 500000) {
            System.out.println("no tax");
        } else if (salary > 500000 && salary <= 1000000) {
            System.out.println("20% tax");
            System.out.printf("pay tax of: %.2f%n", 0.2 * salary);
        } else {
            System.out.println("30% tax");
            System.out.printf("pay tax of: %.2f%n", 0.3 * salary);
        }

        sc.close();
    }
}
