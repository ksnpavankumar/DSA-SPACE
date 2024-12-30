class ContainerWithMostWater:
    # @param heights : list of integers
    # @return an integer
    def findMaxWaterArea(self, heights):
        maxArea = 0
        n = len(heights)
        if n == 0:
            return 0
        i = 0
        j = n - 1
        while i < j:
            maxArea = max(maxArea, (j - i) * min(heights[i], heights[j]))
            if heights[i] < heights[j]:
                i += 1
            else:
                j -= 1
        return maxArea


# Main method to test the implementation
if __name__ == "__main__":
    solution = ContainerWithMostWater()

    # Example test cases
    heights1 = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    print(f"Max water area for {heights1}: {solution.findMaxWaterArea(heights1)}")  # Output: 49

    heights2 = [1, 1]
    print(f"Max water area for {heights2}: {solution.findMaxWaterArea(heights2)}")  # Output: 1

    heights3 = [4, 3, 2, 1, 4]
    print(f"Max water area for {heights3}: {solution.findMaxWaterArea(heights3)}")  # Output: 16

    heights4 = [1, 2, 1]
    print(f"Max water area for {heights4}: {solution.findMaxWaterArea(heights4)}")  # Output: 2


# Intuition:
# - The problem is about finding two vertical lines that together with the x-axis form a container, 
#   such that the container can hold the maximum amount of water.
# - Use two pointers, starting from the leftmost and rightmost lines.
# - Compute the area for the current container formed by the two pointers.
# - Move the pointer pointing to the shorter line inward, as the height is the limiting factor.
# - Continue until the pointers meet, keeping track of the maximum area found.

# Reference diagrams to visualize:

# Example 1:
# Input: [1, 8, 6, 2, 5, 4, 8, 3, 7]
#      |
#      |               |
#      |       |       |       |
#      |       |       |   |   |   |
#      ---------------------------------- (x-axis)
#   Index: 0   1   2   3   4   5   6   7   8
# Explanation: The largest container is formed by lines at index 1 and 8 with height 8 and 7.

# Example 2:
# Input: [4, 3, 2, 1, 4]
#      |               |
#      |               |
#      |       |       |   
#      ---------------------------------- (x-axis)
#   Index: 0   1   2   3   4
# Explanation: The largest container is formed by lines at index 0 and 4 with height 4.

# Example 3:
# Input: [1, 2, 1]
#      |
#      |       |
#      |       |       
#      ---------------------------------- (x-axis)
#   Index: 0   1   2
# Explanation: The largest container is formed by lines at index 0 and 2 with height 1.
