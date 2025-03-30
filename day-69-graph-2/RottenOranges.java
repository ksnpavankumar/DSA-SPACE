import java.util.*;

public class RottenOranges {
    /**
     * This method calculates the minimum time required for all fresh oranges to rot.
     * Uses Breadth-First Search (BFS) to process rotting oranges level by level.
     *
     * @param grid 2D matrix representing the orange grid (0: empty, 1: fresh, 2: rotten)
     * @return Minimum time to rot all oranges, or -1 if some oranges can never rot.
     */
    public int minTimeToRotAll(int[][] grid) {
        Queue<OrangePosition> rottenQueue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;

        // Step 1: Identify initial rotten oranges and count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    rottenQueue.add(new OrangePosition(i, j)); // Store rotten oranges
                } else if (grid[i][j] == 1) {
                    freshOranges++; // Count fresh oranges
                }
            }
        }

        // If there are no fresh oranges, return 0 (no time required)
        if (freshOranges == 0) {
            return 0;
        }

        // Directions for adjacent cells (Left, Right, Down, Up)
        int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int minutes = 0;

        // Step 2: Perform BFS to rot adjacent fresh oranges
        while (!rottenQueue.isEmpty()) {
            int size = rottenQueue.size();
            boolean newRottenFound = false;

            for (int i = 0; i < size; i++) {
                OrangePosition current = rottenQueue.poll();

                for (int[] dir : directions) {
                    int newRow = current.row + dir[0];
                    int newCol = current.col + dir[1];

                    if (isFreshOrange(newRow, newCol, grid, rows, cols)) {
                        grid[newRow][newCol] = 2; // Mark as rotten
                        rottenQueue.add(new OrangePosition(newRow, newCol)); // Add newly rotten orange
                        freshOranges--; // Reduce count of fresh oranges
                        newRottenFound = true;
                    }
                }
            }

            // Increase time only if at least one new orange rotted in this round
            if (newRottenFound) {
                minutes++;
            }
        }

        // If any fresh oranges remain, return -1 (not all oranges can rot)
        return freshOranges == 0 ? minutes : -1;
    }

    /**
     * Helper method to check if a given position contains a fresh orange within grid bounds.
     *
     * @param row Current row position
     * @param col Current column position
     * @param grid 2D matrix representing the orange grid
     * @param rows Total number of rows
     * @param cols Total number of columns
     * @return true if the position contains a fresh orange, otherwise false
     */
    private boolean isFreshOrange(int row, int col, int[][] grid, int rows, int cols) {
        return (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1);
    }

    /**
     * Main method to test the solution with different input cases.
     */
    public static void main(String[] args) {
        RottenOranges solution = new RottenOranges();

        int[][] grid1 = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println("Minimum time to rot all oranges: " + solution.minTimeToRotAll(grid1)); // Expected: 4

        int[][] grid2 = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        System.out.println("Minimum time to rot all oranges: " + solution.minTimeToRotAll(grid2)); // Expected: -1

        int[][] grid3 = {
            {0, 2}
        };
        System.out.println("Minimum time to rot all oranges: " + solution.minTimeToRotAll(grid3)); // Expected: 0
    }
}

/**
 * Helper class to represent an orange's position in the grid.
 */
class OrangePosition {
    int row, col;

    OrangePosition(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

/**
 * Explanation of Algorithm:
 * -----------------------------------
 * This problem is solved using **Breadth-First Search (BFS)**.
 * We process all initially rotten oranges in parallel and rot fresh oranges in waves.
 *
 * 1. **Step 1: Initialization**
 *    - Identify all rotten oranges and add them to the queue.
 *    - Count the number of fresh oranges.
 *    - If there are no fresh oranges, return `0` immediately.
 *
 * 2. **Step 2: BFS Traversal**
 *    - Process rotten oranges **level by level** (each level represents 1 minute).
 *    - For each rotten orange, check all **4 adjacent positions** (left, right, up, down).
 *    - If an adjacent cell contains a fresh orange:
 *      - Mark it as rotten.
 *      - Add it to the queue for processing in the next minute.
 *      - Reduce the fresh orange count.
 *
 * 3. **Step 3: Time Calculation**
 *    - Increase time count if at least **one** fresh orange rots in the current iteration.
 *    - Continue until no more oranges can rot.
 *    - If **some fresh oranges remain**, return `-1` (not all oranges can rot).
 *
 * **Time Complexity:** O(N × M) → Each cell is processed once.
 * **Space Complexity:** O(N × M) → Worst case: all oranges are rotten.
 */
