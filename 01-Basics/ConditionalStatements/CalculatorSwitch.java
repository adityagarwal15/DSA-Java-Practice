package ConditionalStatements;
import java.util.*;

public class CalculatorSwitch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

          sc.nextLine(); //important to clear the buffer if new line from last input sc.nextInt()

          //QuickScannerGuide for more detailed explanation

        System.out.println("Enter operator (+, -, *, /, %): ");
        String operator = sc.nextLine(); 

        switch(operator){
            case "+":
                System.out.println("Result: " + (a + b));
                break;
            case "-":
                System.out.println("Result: " + (a - b));
                break;
            case "*":
                System.out.println("Result: " + (a * b));
                break;
            case "/":
                if (b != 0) {
                    System.out.println("Result: " + (a / b));
                } else {
                    System.out.println("Cannot divide by zero!");
                }
                break;
            case "%":
                if (b != 0) {
                    System.out.println("Result: " + (a % b));
                } else {
                    System.out.println("Cannot modulo by zero!");
                }
                break;
            default:
                System.out.println("Invalid operator!");
        }

        sc.close();
    }
}
