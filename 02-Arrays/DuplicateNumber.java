public class DuplicateNumber {

    public static boolean hasDuplicate(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) { //this loop will pick an element
            for (int j = i + 1; j < numbers.length; j++) { // this loop then will check that element with every other element
                if (numbers[i] == numbers[j]) {
                    return true;  // duplicate found
                }
            }
        }
        return false; // all elements are unique
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 1};
        System.out.println(hasDuplicate(numbers));  // Output: true
    }
}
