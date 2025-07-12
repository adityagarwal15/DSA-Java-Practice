import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap = new ArrayList<>();

    // Insert an element into the heap
    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    // Return the minimum element (root) without removing
    public int peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    // Remove and return the minimum element (root)
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

    // Restore heap property going up from index i
    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i) < heap.get(parent)) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    // Restore heap property going down from index i
    private void heapifyDown(int i) {
        int size = heap.size();

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
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
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(3);
        heap.insert(15);

        System.out.println("Min element: " + heap.peek()); // should print 3

        while (!heap.isEmpty()) {
            System.out.println("Removed: " + heap.remove());
        }
    }
}
