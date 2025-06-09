package OneGo;
import java.util.*;

public class AreaCircle {

    //use double data type because Math.PI is double 
    
    public static double Area(double rad){
        return  Math.PI * rad * rad;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("enter the radius: ");
        double rad = sc.nextDouble();

        double result = Area(rad);
        System.out.print("area of circle: " + result);

        sc.close();

    }
}
