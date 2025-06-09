package OneGo;
import java.util.*;

public class AreaSquare {

    public static int Area(int side){
        return side * side;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("enter side: ");
        int side = sc.nextInt();

        int result = Area(side);
        System.out.print(result);
    }
}
