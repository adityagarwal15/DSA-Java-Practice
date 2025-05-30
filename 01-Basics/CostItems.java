import java.util.Scanner;

public class CostItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the price of pencil: ");
        float pencil = sc.nextFloat();

        System.out.print("Enter the price of pen: ");
        float pen = sc.nextFloat();

        System.out.print("Enter the price of eraser: ");
        float eraser = sc.nextFloat();

        float totalCost = pencil + pen + eraser;

        float gst = totalCost * 0.18f;
        float totalWithGst = totalCost + gst;

        System.out.println("Total cost without GST: " + totalCost);
        System.out.println("GST (18%): " + gst);
        System.out.println("Total cost with GST: " + totalWithGst);

        sc.close();
    }
}
