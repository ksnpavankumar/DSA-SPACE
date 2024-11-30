import java.util.*;

public class FibonacciIterative {
    public static void main(String[] args) {
        // Taking input and producing output using Scanner and System.out
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Input: Index of the Fibonacci number
        
        // Base cases for Fibonacci series
        if (n == 0 || n == 1) {
            System.out.println(n); // Output: 0 or 1 for the first two Fibonacci numbers
            return;
        }
        
        // Variables to store Fibonacci numbers
        int a = 0, b = 1, c = 0;
        
        // Iteratively compute the Nth Fibonacci number
        for (int i = 2; i <= n; i++) {
            c = a + b; // Current Fibonacci number
            a = b;     // Move to the next Fibonacci number
            b = c;
        }
        
        // Output the Nth Fibonacci number
        System.out.println(c);
    }
}

/*
Intuition:
1. This program computes the Nth Fibonacci number iteratively.
2. The Fibonacci sequence starts with 0 and 1, and each subsequent number is the sum of the two preceding ones.
   Example: 0, 1, 1, 2, 3, 5, 8, ...
3. To find the Nth Fibonacci number:
   - If `n = 0` or `n = 1`, the result is directly 0 or 1.
   - For `n > 1`, use a loop to calculate the series iteratively, starting from 0 and 1.
4. We maintain three variables:
   - `a`: Holds the previous Fibonacci number.
   - `b`: Holds the current Fibonacci number.
   - `c`: Temporarily stores the new Fibonacci number during each iteration.
5. The loop runs from 2 to `n`, calculating the sum of the two previous numbers until the Nth Fibonacci is computed.
6. This approach avoids recursion and reduces space complexity, as we only store three variables instead of the entire series.
7. Time Complexity: O(n)
   Space Complexity: O(1)
*/
