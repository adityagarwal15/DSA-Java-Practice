import java.util.Arrays;

public class ChocolateCutting {

    // Function to calculate minimum total cost of cutting the chocolate
    public static int getMinimumCost(int[] horizontalCuts, int[] verticalCuts) {

        // Step 1: Sort both arrays in ascending order
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        // We'll iterate from the back (to simulate descending sort without reverse)
        int hIndex = horizontalCuts.length - 1;
        int vIndex = verticalCuts.length - 1;

        // Initially there's 1 vertical piece and 1 horizontal piece
        int numVerticalPieces = 1;
        int numHorizontalPieces = 1;

        int totalCost = 0;

        // Step 2: Greedy - pick the bigger cut each time
        while (hIndex >= 0 && vIndex >= 0) {
            if (horizontalCuts[hIndex] >= verticalCuts[vIndex]) {
                // Horizontal cut affects all vertical pieces
                totalCost += horizontalCuts[hIndex] * numVerticalPieces;
                numHorizontalPieces++; // because we just made a horizontal cut
                hIndex--;
            } else {
                // Vertical cut affects all horizontal pieces
                totalCost += verticalCuts[vIndex] * numHorizontalPieces;
                numVerticalPieces++; // because we just made a vertical cut
                vIndex--;
            }
        }

        // Step 3: Add remaining horizontal cuts (if any)
        while (hIndex >= 0) {
            totalCost += horizontalCuts[hIndex] * numVerticalPieces;
            hIndex--;
        }

        // Step 4: Add remaining vertical cuts (if any)
        while (vIndex >= 0) {
            totalCost += verticalCuts[vIndex] * numHorizontalPieces;
            vIndex--;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] horizontalCuts = {2, 1, 3, 1, 4};
        int[] verticalCuts = {4, 1, 2};

        int result = getMinimumCost(horizontalCuts, verticalCuts);
        System.out.println("Minimum cost to cut the chocolate: " + result);
    }
}
