class SubarraySumFinder:
    def find_subarray_with_sum(self, nums, target):
        i, j, sum_ = 0, 0, 0
        n = len(nums)

        # Sliding window approach to find the subarray
        while j < n:
            sum_ += nums[j]  # Expand the window by including the current element

            # Shrink the window from the left if the sum exceeds the target
            while sum_ > target and i <= j:
                sum_ -= nums[i]
                i += 1

            # If the sum matches the target, return the subarray
            if sum_ == target:
                return nums[i:j+1]

            j += 1  # Move the window's right end forward

        # Return [-1] if no subarray is found
        return [-1]

# Example usage
finder = SubarraySumFinder()

# Example test cases
print(finder.find_subarray_with_sum([1, 2, 3, 4, 5], 9))  # Output: [2, 3, 4]
print(finder.find_subarray_with_sum([1, 2, 3, 4, 5], 15))  # Output: [1, 2, 3, 4, 5]
print(finder.find_subarray_with_sum([1], 2))  # Output: [-1]
print(finder.find_subarray_with_sum([1], 1))  # Output: [1]

"""
Intuition:
- The goal is to find a contiguous subarray whose sum equals the target.
- Use the sliding window technique:
   1. Start with two pointers (`i` and `j`) at the beginning of the array.
   2. Expand the window by incrementing `j` and adding `nums[j]` to the sum.
   3. If the sum exceeds the target, shrink the window from the left by incrementing `i` and subtracting `nums[i]` from the sum.
   4. When the sum matches the target, the subarray from `i` to `j` is the result.
- This approach ensures every subarray is considered exactly once, achieving O(n) time complexity.
- Space complexity is O(1) as no extra data structures are used, aside from the result array.
"""
