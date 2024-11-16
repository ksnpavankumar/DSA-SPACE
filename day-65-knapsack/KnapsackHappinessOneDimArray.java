public class KnapsackHappinessOneDimArray {
    public static void main(String[] args) {
        // Values (happiness)
        int[] A = {12, 20, 15, 6, 10};
        // Weights
        int[] B = {3, 6, 5, 2, 4};
        // Knapsack capacity
        int C = 8;

        // Initialize DP array
        int[] dp = new int[C + 1];

        // Process each item
        for (int i = 0; i < A.length; i++) {
            // Traverse capacities in reverse to ensure 0/1 property
            for (int w = C; w >= B[i]; w--) {
                dp[w] = Math.max(dp[w], A[i] + dp[w - B[i]]);
            }
        }

        // Maximum happiness for given capacity
        System.out.println("Maximum happiness: " + dp[C]);
    }
}
