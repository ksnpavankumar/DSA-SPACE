import java.lang.*;
import java.util.*;

public class FibonacciDP { // P
    public static void main(String[] args) {
        // Taking input and producing output using Scanner and System.out
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt(); // Input: Index of the Fibonacci number
        
        // Initialize an array to store Fibonacci numbers up to the given index
        int[] fib = new int[input + 1];
        
        // Handle base cases for Fibonacci series
        if (input == 0 || input == 1) {
            System.out.println(input); // Output: 0 or 1 for the first two Fibonacci numbers
            return;
        }

        // Initialize the first two Fibonacci numbers
        fib[0] = 0;
        fib[1] = 1;
        
        // Compute Fibonacci numbers iteratively and store in the array
        for (int i = 2; i <= input; i++) {
            fib[i] = fib[i - 1] + fib[i - 2]; // Each number is the sum of the previous two
        }
        
        // Output the Fibonacci number at the given index
        System.out.println(fib[input]);
    }
}

/*
Intuition:
1. This program computes the Nth Fibonacci number using dynamic programming.
2. The Fibonacci sequence starts with 0 and 1, and each subsequent number is the sum of the two preceding ones.
   Example: 0, 1, 1, 2, 3, 5, 8, ...
3. To compute the Nth Fibonacci number:
   - If `n = 0` or `n = 1`, the result is directly 0 or 1, respectively.
   - For `n > 1`, an array `fib[]` is used to store Fibonacci numbers from 0 to `n`, avoiding recalculating them.
4. The array `fib[]` is initialized with base cases: `fib[0] = 0` and `fib[1] = 1`.
5. The loop runs from 2 to `n`, computing the Fibonacci number at each index by adding the two previous numbers in the series.
6. This approach avoids recursion and uses an array to store intermediate Fibonacci values, making the solution more efficient.
7. Time Complexity: O(n)
   Space Complexity: O(n)
*/
