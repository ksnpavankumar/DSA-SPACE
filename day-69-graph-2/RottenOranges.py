from collections import deque

class RottenOranges:
    def min_time_to_rot_all(self, grid):
        """
        Calculates the minimum time required for all fresh oranges to rot using BFS.
        
        :param grid: 2D list representing the orange grid (0: empty, 1: fresh, 2: rotten)
        :return: Minimum time to rot all oranges, or -1 if some oranges can never rot.
        """
        rows, cols = len(grid), len(grid[0])
        queue = deque()
        fresh_oranges = 0

        # Step 1: Identify initial rotten oranges and count fresh ones
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    queue.append((r, c))  # Store rotten orange position
                elif grid[r][c] == 1:
                    fresh_oranges += 1  # Count fresh oranges

        # If no fresh oranges, return 0 (no time required)
        if fresh_oranges == 0:
            return 0

        # Directions for adjacent cells (left, right, down, up)
        directions = [(0, -1), (0, 1), (1, 0), (-1, 0)]
        minutes = 0

        # Step 2: Perform BFS to rot adjacent fresh oranges
        while queue:
            size = len(queue)
            rotted = False

            for _ in range(size):
                row, col = queue.popleft()  # Process rotten orange

                for dr, dc in directions:
                    new_row, new_col = row + dr, col + dc

                    if self.is_fresh_orange(new_row, new_col, grid, rows, cols):
                        grid[new_row][new_col] = 2  # Mark as rotten
                        queue.append((new_row, new_col))  # Add to queue for next round
                        fresh_oranges -= 1  # Reduce count of fresh oranges
                        rotted = True

            # Increase time only if at least one fresh orange rotted in this round
            if rotted:
                minutes += 1

        # If there are still fresh oranges left, return -1
        return minutes if fresh_oranges == 0 else -1

    def is_fresh_orange(self, row, col, grid, rows, cols):
        """
        Checks if the given position contains a fresh orange within grid bounds.
        
        :param row: Current row position
        :param col: Current column position
        :param grid: 2D list representing the orange grid
        :param rows: Total number of rows
        :param cols: Total number of columns
        :return: True if position contains a fresh orange, otherwise False
        """
        return 0 <= row < rows and 0 <= col < cols and grid[row][col] == 1

# Test cases to validate the solution
if __name__ == "__main__":
    solution = RottenOranges()

    grid1 = [
        [2, 1, 1],
        [1, 1, 0],
        [0, 1, 1]
    ]
    print("Minimum time to rot all oranges:", solution.min_time_to_rot_all(grid1))  # Expected: 4

    grid2 = [
        [2, 1, 1],
        [0, 1, 1],
        [1, 0, 1]
    ]
    print("Minimum time to rot all oranges:", solution.min_time_to_rot_all(grid2))  # Expected: -1

    grid3 = [
        [0, 2]
    ]
    print("Minimum time to rot all oranges:", solution.min_time_to_rot_all(grid3))  # Expected: 0
