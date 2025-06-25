public class InversionCount {

    public static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int mid, invCount = 0;
        if (left < right) {
            mid = (left + right) / 2;

            invCount += mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);

            invCount += merge(arr, temp, left, mid + 1, right);
        }
        return invCount;
    }

    public static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int k = left;
        int invCount = 0;

        while (i <= mid - 1 && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i);  // Count inversions
            }
        }

        while (i <= mid - 1)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return invCount;
    }

    public static int countInversions(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSort(arr, temp, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println("Inversion Count = " + countInversions(arr));  // Output: 3
    }
}
