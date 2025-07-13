import java.util.PriorityQueue;

public class Ropes {

    // Function to calculate minimum cost to connect all ropes
    public static int cost(int[] arr) {
        // MinHeap to always get the two smallest ropes
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();  // by default min heap

        // Add all ropes to heap
        for (int rope : arr) {
            minHeap.add(rope);  //  Just add rope directly
        }

        int totalCost = 0;

        // Combine ropes until one remains(cuz if only 1 is there, nothing to connect with)
        while (minHeap.size() > 1) {
            int first = minHeap.poll();  // smallest
            int second = minHeap.poll(); // second smallest

            int cost = first + second;   // cost to combine them
            totalCost += cost;

            minHeap.add(cost);           // add combined rope back(think mathematically)
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};  // Example ropes

        int result = cost(arr);    // Call the function
        System.out.print("Minimum cost to connect ropes: " + result);
    }
}
