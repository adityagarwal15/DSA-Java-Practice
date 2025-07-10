import java.util.*;

public class JobSequencing {

    // Job class to store id, deadline, and profit of a job
    static class Job {
        int id;
        int deadline;
        int profit;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    // Function to get the maximum deadline among all jobs
    public static int getMaxDeadline(Job[] jobs) {
        int max = 0;
        for (int i = 0; i < jobs.length; i++) {
            if (jobs[i].deadline > max) {
                max = jobs[i].deadline;
            }
        }
        return max;
    }

    // Function to schedule jobs for maximum profit
    public static int[] jobScheduling(Job[] jobs) {
        int n = jobs.length;

        // Step 1: Sort jobs by profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 2: Find the maximum deadline
        int maxDeadline = getMaxDeadline(jobs);

        // Step 3: Create slot array to keep track of occupied days
        boolean[] slotUsed = new boolean[maxDeadline + 1]; // 1-based indexing

        int totalJobs = 0;
        int totalProfit = 0;

        // Step 4: Try assigning each job to the latest available slot
        for (int i = 0; i < n; i++) {
            int deadline = jobs[i].deadline;
            int profit = jobs[i].profit;

            for (int day = deadline; day >= 1; day--) {
                if (!slotUsed[day]) {
                    slotUsed[day] = true;
                    totalJobs++;
                    totalProfit += profit;
                    break; // move to next job
                }
            }
        }

        return new int[]{totalJobs, totalProfit};
    }

    public static void main(String[] args) {
        // Example jobs with id, deadline, and profit
        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };

        // Run the scheduling algorithm
        int[] result = jobScheduling(jobs);

        // Output the final result
        System.out.println("Maximum number of jobs: " + result[0]);
        System.out.println("Maximum total profit: " + result[1]);
    }
}
