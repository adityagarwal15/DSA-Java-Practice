import java.util.*;

public class BeautifulArrayList {

    public static ArrayList<Integer> beautifulArray(int n) {
        return build(n, new HashMap<>());
    }

    private static ArrayList<Integer> build(int n, Map<Integer, ArrayList<Integer>> memo) {
        if (memo.containsKey(n)) return memo.get(n);

        ArrayList<Integer> result = new ArrayList<>();

        if (n == 1) {
            result.add(1);
        } else {
            ArrayList<Integer> left = build((n + 1) / 2, memo); // odd positions
            for (int num : left) {
                result.add(num * 2 - 1);
            }

            ArrayList<Integer> right = build(n / 2, memo); // even positions
            for (int num : right) {
                result.add(num * 2);
            }
        }

        memo.put(n, result);
        return result;
    }

    // For testing
    public static void main(String[] args) {
        int n = 5;
        ArrayList<Integer> beautiful = beautifulArray(n);
        System.out.println(beautiful); // e.g., [3, 1, 2, 5, 4]
    }
}
