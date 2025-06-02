public class PrintSubArrays {

    public static void SubArr(int numbers[]) {
        int count = 0; // to count the total number of subarrays

        // Version using start and end
        // for (int i = 0; i < numbers.length; i++) {
        //     int start = i; // start point
        //     for (int j = i; j < numbers.length; j++) {
        //         int end = j; // end point
        //         for (int k = start; k <= end; k++) { // loop from start to end
        //             System.out.print(numbers[k] + " ");
        //         }
        //         count++;
        //         System.out.println();
        //     }
        //     System.out.println();
        // }

        // Version without using start and end
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(numbers[k] + " ");
                }
                count++; // increment count once 1 subarray is printed
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("The total number of subarrays are: " + count);
    }

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10};
        SubArr(numbers);
    }
}
