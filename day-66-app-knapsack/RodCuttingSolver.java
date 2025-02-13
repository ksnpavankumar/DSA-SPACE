public class RodCuttingSolver {

    // Function to compute the maximum profit for cutting the rod
    public int maxRodCutProfit(int[] prices) {
        int n = prices.length;

        // dp[i] stores the maximum revenue achievable for rod length 'i'
        int[] dp = new int[n + 1];

        // Base case: No rod means no revenue
        dp[0] = 0;

        // Iterate through each possible rod length from 1 to n
        for (int i = 1; i <= n; i++) {
            // Try all possible first cuts from length 1 to i
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], prices[j - 1] + dp[i - j]);
            }
        }

        // Maximum profit for full rod length
        return dp[n];
    }

    // Main method to test with various inputs
    public static void main(String[] args) {
        RodCuttingSolver solver = new RodCuttingSolver();

        // Example 1: Prices for each length from 1 to n
        int[] prices1 = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Max Profit (Example 1): " + solver.maxRodCutProfit(prices1)); // Expected: 22

        // Example 2: Prices where longer rods have lower profit
        int[] prices2 = {2, 5, 7, 3, 9, 10, 4, 15};
        System.out.println("Max Profit (Example 2): " + solver.maxRodCutProfit(prices2)); // Expected: 17

        // Example 3: Rod with only one pricing option
        int[] prices3 = {3};
        System.out.println("Max Profit (Example 3): " + solver.maxRodCutProfit(prices3)); // Expected: 3
    }
}

/*
-------------------- Intuition & Explanation --------------------
The goal is to find the best way to cut a rod of length 'n' to maximize profit.
Each length 'i' has a corresponding price given in the array.

Example 1:
    Prices: [1, 5, 8, 9, 10, 17, 17, 20]  
    Meaning:
        Length 1 = $1
        Length 2 = $5
        Length 3 = $8
        Length 4 = $9
        Length 5 = $10
        Length 6 = $17
        Length 7 = $17
        Length 8 = $20

    If we have a rod of length 8, we check:
    - Cutting into 1 + 7 gives 1 + 17 = 18
    - Cutting into 2 + 6 gives 5 + 17 = 22 (optimal)
    - Cutting into 3 + 5 gives 8 + 10 = 18
    - ...

    The best solution is to cut into two rods of size 2 and 6 for a max profit of **22**.

    The dp array builds solutions step by step for lengths 1 to n, ensuring optimality.

---------------------------------------------------------------
*/

/*
-------------------- Null Pointer Exception & Array Index Out of Bounds Explanation --------------------

### 1. Issue: Using `A[j]` Instead of `A[j - 1]`
   If we mistakenly write:
        dp[i] = Math.max(dp[i], A[j] + dp[i - j]);  // ❌ Incorrect
   - `j` starts from 1, meaning when `j = 1`, this accesses `A[1]` (out of bounds for a small array).
   - When `j = n`, it accesses `A[n]`, which is **out of bounds** since Java uses **0-based indexing**.

   **Correct Fix:** Use `A[j - 1]` to correctly map index:
        dp[i] = Math.max(dp[i], A[j - 1] + dp[i - j]);  // ✅ Correct

### 2. Issue: Null Pointer Exception (`NullPointerException`)
   - If `A` itself is `null`, trying to access `A[j - 1]` will cause a `NullPointerException`.
   - Fix: Add a **null check** at the start:
        if (prices == null) {
            throw new IllegalArgumentException("Prices array cannot be null");
        }

### 3. Key Takeaways:
   ✅ Always use `A[j - 1]` to avoid **ArrayIndexOutOfBoundsException**  
   ✅ Always check for `null` to avoid **NullPointerException**  
   ✅ Correct indexing ensures accurate results and prevents runtime crashes  

---------------------------------------------------------------
*/
