import java.util.*;

public class KthLargest {

    // Function to return a list of kth largest elements after each input in the stream
    public static List<Integer> findK(int[] stream, int k) {
        // MinHeap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // To store results after each input
        List<Integer> result = new ArrayList<>();

        // Traverse the stream
        for (int num : stream) {
            // Step 1: Add the new number to the heap
            minHeap.add(num);

            // Step 2: If heap has more than k elements, remove the smallest
            // This ensures heap only stores the k largest elements seen so far
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            // Step 3:
            // If we have seen at least k elements, the top of the heap is the kth largest
            if (minHeap.size() == k) {
                result.add(minHeap.peek());
            } 
            // Otherwise, we haven't seen enough numbers yet to determine kth largest
            else {
                result.add(null); // Represent with null or placeholder
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] stream = {10, 20, 11, 70, 50, 40, 100, 5};
        int k = 3;

        List<Integer> output = findK(stream, k);

        // Print result in readable format
        System.out.println("Kth largest after each input:");
        fo
