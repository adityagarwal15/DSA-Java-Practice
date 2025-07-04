import java.util.ArrayList;

class MyStack { //this is the class which represents the behaviour of a stack
    private ArrayList<Integer> stack; //private - hidden - so it cannot be accessed directly from outside the class.

    //why private - public means anyone can directly access and modify the stack from outside: st.stack.add(9999); // No control, breaks abstraction (WHICH WE DON'T WANT)


    // Constructor is a special method used to initialize objects.
    public MyStack() {
        stack = new ArrayList<>();
    }

    // Push an element onto the stack
    public void push(int data) {
        stack.add(data);
    }

    // Pop the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1; // or throw exception
        }
        return stack.remove(stack.size() - 1); //returns the int value(top of the stack)
    }

    // Peek at the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // or throw exception
        }
        return stack.get(stack.size() - 1);
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Return size of the stack
    public int size() {
        return stack.size();
    }
}
public class ArrListImplementation {
    public static void main(String[] args) {
        MyStack st = new MyStack(); //just like this we can make multiple obj from MyStack class

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Top element: " + st.peek()); // 30
        System.out.println("Popped element: " + st.pop()); // 30
        System.out.println("Top after pop: " + st.peek()); // 20
        System.out.println("Stack size: " + st.size()); // 2
        System.out.println("Is stack empty? " + st.isEmpty()); // false
    }
}
