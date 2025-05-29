import java.util.*;

public class AreaCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float radius = sc.nextFloat();
        float area = 3.14f * radius * radius;
 
        // double radius = sc.nextDouble();
        // double area = Math.PI * radius * radius;

        System.out.println("Area of Circle: " + area);

        sc.close();
    }
}
