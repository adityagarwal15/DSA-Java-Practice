import java.util.*;

public class Monotonic {

    public static boolean check(ArrayList<Integer> list, int n){
        boolean check = false;
        for(int i=0; i<n-1;i++){
            if(list.get(i)<=list.get(i+1)){
                check = true;
            }
            else if(list.get(i)>= list.get(i+1)){
                check = true;
            }
            else{
                check = false;
            }
        }
        return check;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("enter size: ");
        int n =sc.nextInt();

        System.out.print("enter elements: ");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0 ; i<n ; i++){
            list.add(sc.nextInt());
        }

        check(list,n);
    }
}
