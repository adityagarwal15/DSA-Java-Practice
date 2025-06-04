public class SelectionSort {

    public static void Sort(int numbers[]) {
        // Outer loop - for each position in the array
        for (int i = 0; i < numbers.length - 1; i++) {
            int minPos = i; // assume the current index has the smallest value

            // Inner loop - find the index of the smallest element in the unsorted part
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minPos]) {  // reverse (<) --> (>) to get in descending order
                    minPos = j; // update min index
                }
            }

            // Swap the smallest element[j] with the current element[i]
            int temp = numbers[i];
            numbers[i] = numbers[minPos];
            numbers[minPos] = temp;
        }

        // Print the sorted array once
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static void main(String[] args) {
        int numbers[] = {5, 3, 4, 2, 1};
        Sort(numbers); // Output: 1 2 3 4 5
    }
}
