public class PrintSumMaxMinSubArray {

    public static void SubArr(int numbers[]) {
        int count = 0; // to count the total number of subarrays

        // Version using start and end
        // for (int i = 0; i < numbers.length; i++) {
        //     int start = i; // start point
        //     for (int j = i; j < numbers.length; j++) {
        //         int end = j; // end point
        //         int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        //         for (int k = start; k <= end; k++) { // loop from start to end
        //             System.out.print(numbers[k] + " ");
        //             sum += numbers[k];
        //             max = Math.max(max, numbers[k]);
        //             min = Math.min(min, numbers[k]);
        //         }
        //         System.out.println(" | Sum: " + sum + ", Max: " + max + ", Min: " + min);
        //         count++;
        //     }
        //     System.out.println();
        // }

        // Version without using start and end
        for (int i = 0; i < numbers.length; i++) { // start
            for (int j = i; j < numbers.length; j++) {
                int sum = 0;
                int max = Integer.MIN_VALUE;   // - infinity
                int min = Integer.MAX_VALUE;   // + infinity

                for (int k = i; k <= j; k++) {
                    System.out.print(numbers[k] + " ");  
                    sum += numbers[k];   // sum = sum + numbers[k]  //this will keep running until we get the sum, outermost loop wait for the innermost loops
                    max = Math.max(max, numbers[k]);
                    min = Math.min(min, numbers[k]);
                }

                System.out.println("| Sum: " + sum + ", Max: " + max + ", Min: " + min);
                count++; // increment count once 1 subarray is printed
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


