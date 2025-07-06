import java.util.*;

public class NextSmallerElemLeft {

    public static void smaller(int[] arr, int[] nge){
        Stack<Integer> st = new Stack<>();

        int n = arr.length;

        //loop from 0 to n cuz to the left this is not right
        for(int i=0; i<n; i++){
            
            while(!st.isEmpty() && st.peek()<= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nge[i] = -1;
            }
            else{
                nge[i] = st.peek();
            }

            st.push(arr[i]);
        }
    }
    public static void main(String[] args){

        int arr[] = {6,8,0,1,5};
        int nge[] = new int[arr.length];

        greater(arr,nge);

         System.out.print("Original Arr: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.print("Next Greater Elements: ");
        // Looping on nge because this array was filled in the function above
        for (int i : nge) {
            System.out.print(i + " ");
        }
    }
}
