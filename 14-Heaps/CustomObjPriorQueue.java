import java.util.PriorityQueue;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class CustomObjPriorQueue {
    public static void main(String[] args) {
        
        // ✅ Min Heap (students sorted by lowest marks first)
        PriorityQueue<Student> minHeap = new PriorityQueue<>((a, b) -> a.marks - b.marks);

        minHeap.add(new Student("Alice", 85));
        minHeap.add(new Student("Bob", 95));
        minHeap.add(new Student("Charlie", 75));

        System.out.println("Students in Min Heap (by marks ascending):");
        while (!minHeap.isEmpty()) {
            Student s = minHeap.poll();
            System.out.println(s.name + " - " + s.marks);
        }

        System.out.println();

        // ✅ Max Heap (students sorted by highest marks first)
        PriorityQueue<Student> maxHeap = new PriorityQueue<>((a, b) -> b.marks - a.marks);

        maxHeap.add(new Student("Alice", 85));
        maxHeap.add(new Student("Bob", 95));
        maxHeap.add(new Student("Charlie", 75));

        System.out.println("Students in Max Heap (by marks descending):");
        while (!maxHeap.isEmpty()) {
            Student s = maxHeap.poll();
            System.out.println(s.name + " - " + s.marks);
        }
    }
}
