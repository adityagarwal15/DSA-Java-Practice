import java.util.*;

public class ActivitySelection2D {

    // Function to calculate the maximum number of non-overlapping activities
    public static int maxActivities(int[] start, int[] end) {
        int n = start.length;

        // Step 1: Create a 2D array where each row represents an activity
        // activities[i][0] = start time, activities[i][1] = end time
        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = end[i];
        }

        // Step 2: Sort activities by their end times (ascending order)
        // This is the key greedy step: choosing activities that finish earliest
        //
        // Comparator explanation:
        // Arrays.sort() takes a lambda function here: (a, b) -> a[1] - b[1]
        // - 'a' and 'b' are two rows (int arrays) of the 2D array
        // - a[1] is the end time of activity 'a', b[1] is end time of activity 'b'
        // - If a[1] < b[1], a comes before b
        // - If a[1] > b[1], a comes after b
        // - If equal, their order doesn't change
        //
        // So this sorts the 2D array by the second column (end times) in ascending order
        Arrays.sort(activities, (a, b) -> a[1] - b[1]);

        // Step 3: Always select the first activity (it ends earliest)
        int count = 1; // At least one activity can be selected
        int lastEnd = activities[0][1]; // End time of the last selected activity

        // Step 4: Traverse the rest of the activities
        // If an activity starts after or exactly when the last one ended, select it
        for (int i = 1; i < n; i++) {
            if (activities[i][0] >= lastEnd) { // ith row 0th col(start) > (end)
                count++;
                lastEnd = activities[i][1]; // Update end time of last selected activity
            }
        }

        // Return the total number of non-overlapping activities selected
        return count;
    }

    public static void main(String[] args) {
        // Example input: start and end times of activities
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};

        // Call the function and print the result
        int result = maxActivities(start, end);
        System.out.println("Maximum activities you can attend: " + result);
    }
}
