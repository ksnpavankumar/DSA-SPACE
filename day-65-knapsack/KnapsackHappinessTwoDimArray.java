public class KnapsackHappinessTwoDimArray {
    public int solve(int[] A, int[] B, int C) {
        int n = A.length;
        int[][] dp = new int[n + 1][C + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= C; j++) {
                if (j >= B[i - 1]) {
                    dp[i][j] = Math.max(A[i - 1] + dp[i - 1][j - B[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][C];
    }

    /*
     * This function solves the 0/1 Knapsack problem using Dynamic Programming.
     * It calculates the maximum value (happiness) that can be achieved by selecting 
     * items such that the total weight does not exceed the given knapsack capacity (C).
     *
     * Parameters:
     * A[] - Array containing the values (happiness) of each item.
     * B[] - Array containing the weights of each item.
     * C - Maximum weight capacity of the knapsack.
     *
     * Returns:
     * The maximum achievable value that can be obtained with the given knapsack capacity.
     *
     * Detailed Explanation:
     * 1. Initialize the dp array where dp[i][j] stores the maximum value achievable 
     *    using the first i items with a knapsack capacity of j.
     * 
     * 2. Iterate through all items (i from 1 to n) and all knapsack capacities (j from 0 to C):
     *    - If the current item's weight is less than or equal to the current capacity, 
     *      two options are considered:
     *      a) Include the item: Add the value of the item (A[i-1]) and the value of 
     *         the remaining capacity (dp[i-1][j - B[i-1]]).
     *      b) Exclude the item: Simply carry forward the maximum value without including 
     *         the current item (dp[i-1][j]).
     *    - If the item cannot fit in the current capacity, we exclude the item, and 
     *      the value remains the same as the previous row (dp[i-1][j]).
     *
     * 3. After all iterations, the maximum achievable value with n items and capacity C 
     *    is stored in dp[n][C].
     */
}
