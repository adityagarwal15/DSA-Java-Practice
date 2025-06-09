package OneGo;
import java.util.*;

public class IncomeTax {

    public static void Tax(double salary) {
        if (salary <= 500000) {
            System.out.println("No tax");
            System.out.printf("Amount to pay: ₹%.2f%n", salary);
        } else if (salary <= 1000000) {
            double taxpay = 0.2 * salary;  // 20% tax
            double pay = salary - taxpay;
            System.out.printf("Tax to pay: ₹%.2f%n", taxpay);
            System.out.printf("Amount to pay: ₹%.2f%n", pay);
        } else {
            double taxpay = 0.3 * salary;  // 30% tax
            double pay = salary - taxpay;
            System.out.printf("Tax to pay: ₹%.2f%n", taxpay);
            System.out.printf("Amount to pay: ₹%.2f%n", pay);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();

        Tax(salary);
        sc.close();
    }
}
