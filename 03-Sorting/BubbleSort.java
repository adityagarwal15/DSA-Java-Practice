public class BubbleSort {

    public static void Sort(int numbers[]) {

        // number of turns loop
        for (int turn = 0; turn < numbers.length - 1; turn++) {
            boolean swapped = false; // track if any swapping happened in this turn

            // loop for comparison and swapping
            for (int j = 0; j < numbers.length - 1 - turn; j++) {

                // Explanation:
                // We go up to (length - 1 - turn) because after each turn,
                // the largest element of the unsorted part is pushed to the end.
                // So we don't need to check the last 'turn' elements again —
                // they are already in their correct sorted position.
                
                if (numbers[j] > numbers[j + 1]) {
                    // Swap
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true; // mark that a swap occurred
                }
            }

            // If no swaps in this pass, array is already sorted
            if (!swapped) {
                break; // break out of the loop early
            }
        }

        // Print the sorted array
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static void main(String[] args) {
        int numbers[] = {5, 4, 1, 3, 2};
        Sort(numbers);
    }
}
