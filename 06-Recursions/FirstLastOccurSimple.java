public class FirstLastOccurSimple {

    public static int firstOccurrence(int[] arr, int index, int key) {
        if (index == arr.length) return -1;
        if (arr[index] == key) return index;
        return firstOccurrence(arr, index + 1, key);
    }

    public static int lastOccurrence(int[] arr, int index, int key) {
        if (index < 0) return -1;
        if (arr[index] == key) return index;
        return lastOccurrence(arr, index - 1, key);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 2, 7, 9, 7};
        int key = 7;

        int first = firstOccurrence(arr, 0, key);
        int last = lastOccurrence(arr, arr.length - 1, key);

        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
    }
}
