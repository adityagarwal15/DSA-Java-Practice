import java.util.*;

public class MaxAreaHistogram {

    public static int maxArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        int[] NSL = new int[n]; // NSL[i] stores index of Nearest Smaller to Left
        int[] NSR = new int[n]; // NSR[i] stores index of Nearest Smaller to Right

        Stack<Integer> st = new Stack<>();

        // Step 1: Fill NSL (Nearest Smaller to Left)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            // If no smaller to left → -1
            NSL[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i); // Push index
        }

        st.clear(); // Reuse stack

        // Step 2: Fill NSR (Nearest Smaller to Right)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            // If no smaller to right → n (outside the boundary)
            NSR[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        // Step 3: Calculate max area for each bar using NSL and NSR
        for (int i = 0; i < n; i++) {
           int height = heights[i]; // current bar's height — remains fixed when calculating area for this bar
            int width = NSR[i] - NSL[i] - 1; //j-i-1
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        int area = maxArea(heights);
        System.out.println("Maximum Area in Histogram: " + area); // Output: 10
    }
}
