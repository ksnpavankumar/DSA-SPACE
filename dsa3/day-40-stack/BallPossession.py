class BallPossession:

    # @param A : integer
    # @param B : integer
    # @param C : list of integers
    # @return an integer
    def find_final_possession(self, A, B, C):
        stack = [B]
        for i in C:
            if i == 0:
                stack.pop()
            else:
                stack.append(i)
        return stack[-1]

    # Main method to test the solution
    if __name__ == "__main__":
        ball_possession = BallPossession()

        # Test case 1: Basic test case
        A1 = 5
        B1 = 2
        C1 = [1, 2, 0, 3, 4]
        print("Result for test case 1: ", ball_possession.find_final_possession(A1, B1, C1))  # Expected output: 4

        # Test case 2: All elements are zero, testing pop behavior
        A2 = 4
        B2 = 5
        C2 = [0, 0, 0, 0]
        print("Result for test case 2: ", ball_possession.find_final_possession(A2, B2, C2))  # Expected output: -1

        # Test case 3: No pops, testing the stack behavior with positive values
        A3 = 3
        B3 = 10
        C3 = [1, 2, 3]
        print("Result for test case 3: ", ball_possession.find_final_possession(A3, B3, C3))  # Expected output: 3

        # Test case 4: Stack pops and pushes, typical mixed case
        A4 = 6
        B4 = 8
        C4 = [3, 0, 1, 2, 0, 4]
        print("Result for test case 4: ", ball_possession.find_final_possession(A4, B4, C4))  # Expected output: 4

    """
    Intuition:
    1. The solution simulates the ball possession behavior based on the input array C.
    2. Initially, we push the element B (the starting player) onto the stack.
    3. Then for each element in C:
       - If the element is non-zero, the ball is passed to the player with the ID in the array.
       - If the element is zero, the ball is passed back to the previous player (we pop the top element from the stack).
    4. After processing all elements:
       - The top element of the stack represents the player who currently possesses the ball.
    5. The solution has a time complexity of O(A), where A is the number of passes.
    """
