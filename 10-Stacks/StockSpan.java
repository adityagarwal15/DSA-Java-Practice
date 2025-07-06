import java.util.*;

public class StockSpan {

    public static void stockSpan(int[] stocks, int[] span) {
        int n = stocks.length;
        Stack<Integer> st = new Stack<>(); // Stack stores **indices** of previous days, NOT the prices themselves

        for (int i = 0; i < n; i++) {

            int currPrice = stocks[i];

            // Step 1: Remove indices from stack while their prices are <= current price
            // Why? Because they can't contribute to span anymore — they're smaller or equal
            while (!st.isEmpty() && stocks[st.peek()] <= currPrice) {
                st.pop();
            }

            // Step 2: Calculate span for the current day
            if (st.isEmpty()) {
                // Stack empty means no greater price found on left → full span = i + 1
                span[i] = i + 1;
            } else {
                // Stack top (peek) is index of previous greater price → subtract to get distance
                int prevHigh = st.peek();
                span[i] = i - prevHigh; // no. of consecutive days between curr day and prevHigh
            }

            // Step 3: Push current day's index into the stack for future reference
            // We're storing index, not value, so that we can calculate span later using positions
            st.push(i);
        }
    }

    public static void main(String[] args) {
        int[] stocks = {100, 80, 60, 70, 60, 75, 85};
        int[] span = new int[stocks.length];

        stockSpan(stocks, span);

        System.out.print("Stock spans: ");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
