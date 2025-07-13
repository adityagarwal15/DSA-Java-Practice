import java.util.*;

public class KthLargest {

    /* -------------------- Key Idea --------------------
       We only need to track the top K elements at any point in time.
       
       Use a Min-Heap of size K:
       Why min-heap?
       - Because it keeps the smallest of the K largest numbers at the top.
       - So, the top of the heap is the Kth largest element.
    */

    // Function to return a list of Kth largest elements after each input in the stream
    public static List<Integer> findK(int[] stream, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();  // MinHeap to track K largest
        List<Integer> result = new ArrayList<>();                // List to store Kth largest at each step

        // Process each number in the stream
        for (int num : stream) {
            minHeap.add(num);  // Step 1: Add new number to heap

            // Step 2: Maintain size of heap to k
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove the smallest among the top K
            }

            // Step 3: If we have at least k elements, the Kth largest is the heap top
            if (minHeap.size() == k) {
                result.add(minHeap.peek());
            } else {
                result.add(null);  // Not enough elements yet to determine Kth largest
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] stream = {10, 20, 11, 70, 50, 40, 100, 5};
        int k = 3;

        List<Integer> output = findK(stream, k);

        System.out.println("Kth largest after each input:");
        for (Integer val : output) {
            System.out.print((val == null ? "__" : val) + " ");
        }
    }
}
