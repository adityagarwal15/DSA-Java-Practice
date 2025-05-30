import java.util.Scanner;

public class AreaSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the side length of the square: ");
        double side = sc.nextDouble();

        double area = side * side;

        System.out.println("Area of the square: " + area);

        sc.close();
    }
}
