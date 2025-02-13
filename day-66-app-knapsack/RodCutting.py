class RodCutting:
    def max_profit(self, prices):
        """
        Computes the maximum profit that can be obtained by cutting a rod.

        :param prices: List[int] -> A list where prices[i] represents the price of a rod of length i+1.
        :return: int -> Maximum profit possible.
        """

        if prices is None:
            raise ValueError("Prices array cannot be None")

        n = len(prices)
        dp = [0] * (n + 1)  # dp[i] stores max profit for a rod of length i

        # Iterate through rod lengths
        for i in range(1, n + 1):
            # Try all possible first cuts
            for j in range(i):
                dp[i] = max(dp[i], prices[j] + dp[i - j - 1])

        return dp[n]

    """
    -------------------------------- Explanation & Walkthrough --------------------------------

    ## Problem: Rod Cutting
    Given a rod of length `n`, and an array `prices` where `prices[i]` represents the price of a rod of length `i+1`,
    determine the maximum revenue that can be obtained by cutting the rod into smaller pieces.

    ### Dynamic Programming Approach:
    1️⃣ **Define `dp[i]` as the maximum profit achievable for a rod of length `i`.**
    2️⃣ **Base Case:** `dp[0] = 0` (a rod of length `0` has zero profit).
    3️⃣ **Recurrence Relation:**  
       - For each `i`, we check **all possible first cuts** and choose the best one.  
       - Formula:  
         \[
         dp[i] = \max(dp[i], \text{price of first cut} + \text{best revenue for remaining length})
         \]
       - In code:  
         ```python
         for i in range(1, n+1):
             for j in range(i):
                 dp[i] = max(dp[i], prices[j] + dp[i - j - 1])
         ```
    4️⃣ **Final Answer:** `dp[n]` contains the maximum profit for rod length `n`.

    ### Example Walkthrough:
    #### **Input Prices:**  
    ```python
    prices = [1, 5, 8, 9, 10, 17, 17, 20]
    ```

    #### **Step-by-Step DP Calculation**
    | Rod Length (`i`) | Possible Cuts | Max Profit (`dp[i]`) |
    |------------------|--------------|----------------------|
    | `1` | `1` → `1` | **1** |
    | `2` | `1+1=2`, `2=5` | **5** |
    | `3` | `1+2=6`, `2+1=6`, `3=8` | **8** |
    | `4` | `1+3=9`, `2+2=10`, `3+1=9`, `4=9` | **10** |
    | `5` | `1+4=11`, `2+3=13`, `3+2=13`, `4+1=10`, `5=10` | **13** |
    | `6` | `1+5=14`, `2+4=15`, `3+3=16`, `4+2=14`, `5+1=11`, `6=17` | **17** |
    | `7` | `1+6=18`, `2+5=18`, `3+4=17`, `4+3=17`, `5+2=15`, `6+1=18`, `7=17` | **17** |
    | `8` | `1+7=19`, `2+6=22`, `3+5=21`, `4+4=18`, `5+3=18`, `6+2=22`, `7+1=18`, `8=20` | **22** |

    ✅ **Optimal Cutting:**  
    - Best way to cut the rod of length **8** → Cut into **lengths 2 & 6** (Profit: `5 + 17 = 22`).

    ### **Handling the `A[j]` Null Pointer Exception**
    - If we mistakenly use `A[j]` instead of `A[j-1]` in Java, it can lead to an **IndexOutOfBoundsException**.
    - **Why?** Because `j` loops from `1 to i`, and arrays are **zero-indexed**.
    - Fix: Always reference `A[j-1]` to avoid accessing `A[N]` (out of bounds).

    ### **Edge Cases Considered**
    1️⃣ **All elements are the same** (e.g., `[1,1,1,1,1]`) ✅  
    2️⃣ **Single-element array** (e.g., `[3]`) ✅  
    3️⃣ **Non-increasing price sequence** (e.g., `[10, 9, 8, 7]`) ✅  
    4️⃣ **Large numbers in between** (e.g., `[2, 4, 9, 10, 11, 20, 22, 25]`) ✅  
    5️⃣ **Null check** (if input is `None`, raise `ValueError`) ✅  

    ### **Time Complexity Analysis**
    - **Outer Loop (`i`) runs `n` times**.
    - **Inner Loop (`j`) runs up to `i` times**.
    - **Total iterations ≈**  
      \[
      1 + 2 + 3 + ... + n = \frac{n(n+1)}{2} = O(n^2)
      \]
    - ✅ **Time Complexity: `O(n²)`**
    - ✅ **Space Complexity: `O(n)`** (only `dp` array used)

    """

# Main function to test different inputs
if __name__ == "__main__":
    solver = RodCutting()

    prices1 = [1, 5, 8, 9, 10, 17, 17, 20]
    print("Max Profit (Example 1):", solver.max_profit(prices1))  # Expected: 22

    prices2 = [2, 5, 7, 3, 9, 10, 4, 15]
    print("Max Profit (Example 2):", solver.max_profit(prices2))  # Expected: 17

    prices3 = [3]
    print("Max Profit (Example 3):", solver.max_profit(prices3))  # Expected: 3

    prices4 = [1, 1, 1, 1, 1, 1, 1, 1]
    print("Max Profit (Example 4):", solver.max_profit(prices4))  # Expected: 8

    prices5 = [2, 4, 9, 10, 11, 20, 22, 25]
    print("Max Profit (Example 5):", solver.max_profit(prices5))  # Expected: 25)
