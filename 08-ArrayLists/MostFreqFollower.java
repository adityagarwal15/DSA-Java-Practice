import java.util.*;

public class MostFreqFollower {

    public static int findMostFrequentTarget(ArrayList<Integer> nums, int key) {
        int n = nums.size();
        int[] freq = new int[1000001]; // frequency array, since max value <= 10^6

        // Count frequencies of numbers appearing after the key
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == key) {
                int target = nums.get(i + 1); // the number that comes after key
                freq[target]++;
            }
        }

        // Find the number with the highest frequency
        int maxFreq = 0;
        int result = -1;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                result = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of list: ");
        int n = sc.nextInt();

        System.out.print("Enter elements: ");
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }

        System.out.print("Enter key: ");
        int key = sc.nextInt();

        int mostFrequent = findMostFrequentTarget(nums, key);
        System.out.println("Most frequent number after key is: " + mostFrequent);
    }
}
