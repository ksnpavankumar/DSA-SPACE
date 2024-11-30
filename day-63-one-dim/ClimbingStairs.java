public class ClimbingStairs { // More descriptive class name
    public int climbStairs(int A) { // P
        int mod = 1000000007; // Modulo value to prevent overflow
        if (A == 0 || A == 1) {
            return 1; // Base cases: 0 stairs or 1 stair can only be climbed in 1 way
        }
        
        int a = 1, b = 1, c = 0; // a and b represent the number of ways to climb the previous 2 steps
        for (int i = 2; i <= A; i++) {
            c = (a % mod + b % mod) % mod; // Sum the number of ways to reach the current step (i-1 and i-2 steps)
            a = b; // Move to the next step (shift the previous value of b to a)
            b = c; // Move to the next step (shift the current value of c to b)
        }
        
        return c; // Return the number of ways to reach the top (A-th step)
    }
}

/*
Intuition:
1. The problem is to find the number of distinct ways to climb a staircase with A steps, where at each step, you can either climb 1 or 2 steps.
2. This is a dynamic programming problem that can be reduced to a Fibonacci-like problem:
   - To reach step `i`, you can either come from step `i-1` or step `i-2`.
   - Therefore, the number of ways to reach step `i` is the sum of ways to reach steps `i-1` and `i-2`.
3. We use two variables, `a` and `b`, to store the number of ways to reach the previous two steps, and `c` stores the current step's result.
4. The modulo operation (`% mod`) is used to avoid overflow for large values of A (up to 10^9).
5. Base cases:
   - `climbStairs(0)` = 1 (1 way to stay at the ground).
   - `climbStairs(1)` = 1 (1 way to climb the first step).
6. Time Complexity: O(A) – The loop runs A-1 times.
   Space Complexity: O(1) – We only store a few variables (`a`, `b`, and `c`).
*/

/*
Small Tree Diagram of Data:

For A = 4:

  climbStairs(4) = climbStairs(3) + climbStairs(2)
  /             \
  |               \
climbStairs(3)   climbStairs(2)    <- Reached through climbStairs(1) + climbStairs(0)
    /      \
   |        \
climbStairs(2) climbStairs(1)      <- Reached through climbStairs(1) + climbStairs(0)
       |
climbStairs(1)  <- Base case (1 way to climb the first step)

Result: 
- climbStairs(4) = climbStairs(3) + climbStairs(2) 
- climbStairs(3) = climbStairs(2) + climbStairs(1) 
- climbStairs(2) = climbStairs(1) + climbStairs(0)
*/

