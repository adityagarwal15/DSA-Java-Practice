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

    // Function to find max number of jobs done and max profit
    public static int[] jobScheduling(Job[] jobs) {
        // Step 1: Sort jobs by profit in descending order
        Arrays.sort(jobs, new Comparator<Job>() {
            public int compare(Job a, Job b) {
                return b.profit - a.profit;
            }
        });

        // Step 2: Find the maximum deadline to know how many slots we need
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // Step 3: Create a slot array to keep track of used days (1-based indexing)
        boolean[] slotUsed = new boolean[maxDeadline + 1];  // false = free, true = occupied
        int totalJobs = 0;
        int totalProfit = 0;

        // Step 4: Try to assign each job to the latest available day before its deadline
        for (Job job : jobs) {
            for (int day = job.deadline; day >= 1; day--) {
                if (!slotUsed[day]) {
                    slotUsed[day] = true;     // Mark this day as used
                    totalJobs++;              // Count this job
                    totalProfit += job.profit; // Add its profit
                    break;                    // Move to the next job
                }
            }
        }

        // Return the number of jobs done and the total profit earned
        return new int[]{totalJobs, totalProfit};
    }

    public static void main(String[] args) {
        // Creating a list of jobs with id, deadline, and profit
        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };

        // Call the job scheduling function
        int[] result = jobScheduling(jobs);

        // Output the results
        System.out.println("Maximum number of jobs: " + result[0]);
        System.out.println("Maximum total profit: " + result[1]);
    }
}
