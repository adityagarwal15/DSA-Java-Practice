package OneGo;
import java.util.*;

public class TotalCost {
    
    public static void Total(float item1, float item2, float item3) {
        float totalSum = item1 + item2 + item3;
        System.out.printf("Total cost of the items w/o GST is: ₹%.2f%n", totalSum);

        float GST = 0.18f * totalSum;
        float totalCostGST = totalSum + GST;

        System.out.printf("Total cost of items with GST (18%%): ₹%.2f%n", totalCostGST);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter price of item1: ");
        float item1 = sc.nextFloat();

        System.out.print("Enter price of item2: ");
        float item2 = sc.nextFloat();

        System.out.print("Enter price of item3: ");
        float item3 = sc.nextFloat();

        Total(item1, item2, item3);

        sc.close();
    }
}
