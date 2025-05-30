package ConditionalStatements;
import java.util.*;
public class PassFail {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your marks: ");
        double marks = sc.nextDouble();

        // if(marks>=33){
        //     System.out.println("Pass");
        // }
        // else{
        //     System.out.println("FAIL");
        // }

        String res = (marks>=33) ? "Pass" : "Fail";
            System.out.println(res);
        sc.close();

    }
}
