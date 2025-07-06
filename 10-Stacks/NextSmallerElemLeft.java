import java.util.*;

public class NextSmallerElemLeft {

    public static void smaller(int[] arr, int[] nse){
        Stack<Integer> st = new Stack<>();

        int n = arr.length;

        //loop from 0 to n cuz to the left this is not right
        for(int i=0; i<n; i++){
            
            while(!st.isEmpty() && st.peek()>= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nse[i] = -1;
            }
            else{
                nse[i] = st.peek();
            }

            st.push(arr[i]);
        }
    }
    public static void main(String[] args){

        int arr[] = {6,8,0,1,5};
        int nse[] = new int[arr.length];

        smaller(arr,nse);

         System.out.print("Original Arr: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.print("Next Smaller Elements: ");
        // Looping on nge because this array was filled in the function above
        for (int i : nse) {
            System.out.print(i + " ");
        }
    }
}
