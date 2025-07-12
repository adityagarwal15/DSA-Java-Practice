import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<Integer> heap = new ArrayList<>();

    // Insert an element into the heap
    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    // Return the maximum element (root) without removing
    public int peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    // Remove and return the maximum element (root)
    public int remove() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int root = heap.get(0);
        int lastVal = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastVal);
            heapifyDown(0);
        }

        return root;
    }

    // Restore max-heap property going up from index i
    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i) > heap.get(parent)) { // MaxHeap: child > parent
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    // Restore max-heap property going down from index i
    private void heapifyDown(int i) {
        int size = heap.size();

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < size && heap.get(left) > heap.get(largest)) {
                largest = left;
            }

            if (right < size && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest != i) {
                swap(i, largest);
                i = largest;
            } else {
                break;
            }
        }
    }

    // Swap elements at indices i and j
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Get the current size of the heap
    public int size() {
        return heap.size();
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // ✅ Main method to test the MaxHeap
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();

        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(3);
        heap.insert(15);

        System.out.println("Max element: " + heap.peek()); // should print 20

        while (!heap.isEmpty()) {
            System.out.println("Removed: " + heap.remove());
        }
    }
}
