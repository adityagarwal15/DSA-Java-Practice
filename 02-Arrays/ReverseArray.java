public class ReverseArray {

    public static void Reverse(int numbers[]) {
        int start = 0;
        int end = numbers.length - 1;

        while(start < end) {  //avoid start<=end (NOT WRONG BUT REDUNDANT)

            //classic swapping technique
            int temp = numbers[end];
            numbers[end] = numbers[start];
            numbers[start] = temp;

            start++;   // move start + 1
            end--;     // move end - 1
        }
    }

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10};

        Reverse(numbers); //original array gets updated cuz call by reference

        //print reversed array

        System.out.print("Reversed array is: ");
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
