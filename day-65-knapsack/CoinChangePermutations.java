public class CoinChangePermutations {
    public static void main(String[] args) {
        int k = 5; // Target amount
        int[] A = {3, 1, 4}; // Coin denominations

        System.out.println("Number of permutations: " + countPermutations(k, A));
    }

    public static int countPermutations(int k, int[] A) {
        int[] dp = new int[k + 1]; // DP array to store permutations count
        dp[0] = 1; // Base case: 1 way to make amount 0

        // Fill DP array
        for (int i = 1; i <= k; i++) { // For each target amount i
            for (int coin : A) { // Try every coin
                if (coin <= i) { // Check if the coin can contribute to amount i
                    dp[i] += dp[i - coin]; // Add permutations from (i - coin)
                }
            }
        }

        return dp[k]; // Result: permutations to make amount k
    }

    /*
    Each rupee from 1-5 : we are forming though A={3,1,4}
    ==================== DRY RUN EXPLANATION ====================
    Inputs:
        k = 5 (target amount)
        A = [3, 1, 4] (coin denominations)

    Initial dp array: [1, 0, 0, 0, 0, 0]
    
    Step-by-step dry run:

    1. Calculating dp[1]:
       - Coin 1: dp[1] += dp[0] (1) -> dp[1] = 1
       Final dp array: [1, 1, 0, 0, 0, 0]

    2. Calculating dp[2]:
       - Coin 1: dp[2] += dp[1] (1) -> dp[2] = 1
       Final dp array: [1, 1, 1, 0, 0, 0]

    3. Calculating dp[3]:
       - Coin 3: dp[3] += dp[0] (1) -> dp[3] = 1
       - Coin 1: dp[3] += dp[2] (1) -> dp[3] = 2
       Final dp array: [1, 1, 1, 2, 0, 0]

    4. Calculating dp[4]:
       - Coin 3: dp[4] += dp[1] (1) -> dp[4] = 1
       - Coin 1: dp[4] += dp[3] (2) -> dp[4] = 3
       - Coin 4: dp[4] += dp[0] (1) -> dp[4] = 4
       Final dp array: [1, 1, 1, 2, 4, 0]

    5. Calculating dp[5]:
       - Coin 3: dp[5] += dp[2] (1) -> dp[5] = 1
       - Coin 1: dp[5] += dp[4] (4) -> dp[5] = 5
       - Coin 4: dp[5] += dp[1] (1) -> dp[5] = 6
       Final dp array: [1, 1, 1, 2, 4, 6]

    Final Result:
        dp[k] = dp[5] = 6

    Explanation:
        The permutations are formed by ordering the coins in all possible ways to sum up to k = 5.
        Example for k = 5, A = [3, 1, 4]:
        - {1, 1, 1, 1, 1}, {1, 4}, {4, 1}, {3, 1, 1}, {1, 3, 1}, {1, 1, 3}

    Final dp array after calculation: [1, 1, 1, 2, 4, 6]
    */
}
