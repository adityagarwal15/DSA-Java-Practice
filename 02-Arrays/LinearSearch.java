
import java.util.*;

public class LinearSearch {

    public static int MenuSearch(String menu[], String menu_key){
        for(int i =0; i<menu.length;i++){
            if(menu[i] == menu_key){
                return i;
            }
        }
        return -1;
    }

    public static int Linear(int numbers[], int key){
        
        for (int i = 0; i<numbers.length; i++){
            if(numbers[i] == key){
                return i;
            }
        }
        return -1; //if key not found
    }

    public static void main(String[] args){
        int numbers[] = {1,2,3,4,5,6,7,8,9,10};
        int key = 17;

        String menu[] = {"dosa", "idli", "golgappe"};
        String menu_key = "idli";

        int result = Linear(numbers,key);
        if(result == -1){
            System.out.print("key not found");
        }
        else{
        System.out.println("key found at index: " + result);
        }

        System.out.println();

        int menu_result = MenuSearch(menu,menu_key);
        if(menu_result == -1){
            System.out.print("key not found");
        }
        else{
        System.out.println("menu key found at index: " + menu_result);
        }

    }
}
