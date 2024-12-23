import java.util.Stack;

public class StackProcessor {

    public int processStack(int A, int B, int[] C) {
        if (A == 1) {
            return C[0];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(B);

        for (int i = 0; i < A; i++) {
            if (C[i] == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(C[i]);
            }
        }
        return stack.isEmpty() ? -1 : stack.pop();
    }

    public static void main(String[] args) {
        StackProcessor processor = new StackProcessor();

        // Test case 1: Basic test case
        int A1 = 5;
        int B1 = 2;
        int[] C1 = {1, 2, 0, 3, 4};
        System.out.println("Result for test case 1: " + processor.processStack(A1, B1, C1));  // Expected output: 4

        // Test case 2: All elements are zero, testing pop behavior
        int A2 = 4;
        int B2 = 5;
        int[] C2 = {0, 0, 0, 0};
        System.out.println("Result for test case 2: " + processor.processStack(A2, B2, C2));  // Expected output: -1

        // Test case 3: No pops, testing the stack behavior with positive values
        int A3 = 3;
        int B3 = 10;
        int[] C3 = {1, 2, 3};
        System.out.println("Result for test case 3: " + processor.processStack(A3, B3, C3));  // Expected output: 3

        // Test case 4: Stack pops and pushes, typical mixed case
        int A4 = 6;
        int B4 = 8;
        int[] C4 = {3, 0, 1, 2, 0, 4};
        System.out.println("Result for test case 4: " + processor.processStack(A4, B4, C4));  // Expected output: 4
    }


    /*
     * Intuition:
     * 1. The solution simulates stack behavior based on the input array C.
     * 2. Initially, we push the element B onto the stack.
     * 3. Then for each element in C:
     *    - If the element is non-zero, we push it onto the stack.
     *    - If the element is zero, we pop the top element from the stack (if not empty).
     * 4. After processing all elements:
     *    - If the stack is empty, return -1.
     *    - Otherwise, return the top element of the stack.
     * The solution has a time complexity of O(A), where A is the size of the array C.
     * 
     * ==================
     * There is a football event going on in your city. In this event, you are given A passes and players having ids between 1 and 106.
     * 
     * Initially, some player with a given id had the ball in his possession. You have to make a program to display the id of the player who possessed the ball after exactly A passes.
     * 
     * There are two kinds of passes:
     * 
     * 1) ID
     * 2) 0
     * 
     * For the first kind of pass, the player in possession of the ball passes the ball "forward" to the player with id = ID.
     * 
     * For the second kind of pass, the player in possession of the ball passes the ball back to the player who had forwarded the ball to him.
     * 
     * In the second kind of pass "0" just means Back Pass.
     * 
     * Return the ID of the player who currently possesses the ball.
     * 
     * Problem Constraints:
     * 
     * 1 <= A <= 100000
     * 
     * 1 <= B <= 100000
     * 
     * |C| = A
     */
}
