import java.util.ArrayList;

public class StaircaseCombinations { // Renamed for clarity
    /**
     * Generates all possible ways to climb a staircase with A steps,
     * where you can take 1 or 2 steps at a time.
     *
     * @param A The total number of steps in the staircase.
     * @return A list of all possible combinations of steps.
     */
    public ArrayList<ArrayList<Integer>> findWaysToClimb(int A) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>(); // Stores all valid combinations
        backtrack(results, new ArrayList<>(), A);
        return results;
    }

    /**
     * Backtracking method to explore all combinations of steps.
     *
     * @param results The list to store valid step combinations.
     * @param temp    The current combination being explored.
     * @param steps   The remaining number of steps to climb.
     */
    private void backtrack(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> temp, int steps) {
        // Base case: If steps become negative, this path is invalid (e.g., overshot the goal).
        if (steps < 0) {
            return;
        }

        // Base case: If steps reduce to 0, a valid combination is found.
        // This indicates we have successfully used up all steps to reach the top.
        if (steps == 0) {
            results.add(new ArrayList<>(temp)); // Add a copy of the current combination to results
            return;
        }

        // Recursive case: Explore the option of taking a step of size 1
        temp.add(1); // Add step of size 1 to the current path
        backtrack(results, temp, steps - 1); // Reduce the remaining steps by 1 and recurse
        temp.remove(temp.size() - 1); // Backtrack: Remove the last step added to try another option

        // Recursive case: Explore the option of taking a step of size 2
        temp.add(2); // Add step of size 2 to the current path
        backtrack(results, temp, steps - 2); // Reduce the remaining steps by 2 and recurse
        temp.remove(temp.size() - 1); // Backtrack: Remove the last step added to restore state
    }

    /**
     * Intuition Behind Backtracking:
     * - The problem can be visualized as a tree where each node represents a decision to take a step of size 1 or 2.
     * - At each node, we branch into two possibilities: taking a step of size 1 or size 2.
     * - The base cases stop the recursion when an invalid or valid path is reached.
     * - Backtracking ensures that after exploring one path, we "undo" the decision (remove the last step) and try other paths.
     * - This systematic exploration generates all possible step combinations.
     *
     * Time Complexity:
     * - The recursion generates all possible combinations of steps.
     * - For A steps, the number of combinations follows the Fibonacci sequence.
     * - Complexity: O(2^A), where A is the total number of steps.
     *
     * Space Complexity:
     * - The recursion depth is at most A, corresponding to the height of the tree.
     * - Each path is stored temporarily in the "temp" list.
     * - Space Complexity: O(A), for the call stack and temporary list.
     */

    /**
     * Execution Flow (Example for A = 3):
     * 1. Start with temp = [], steps = 3.
     * 2. Add 1 -> temp = [1], steps = 2.
     * 3. Add 1 -> temp = [1, 1], steps = 1.
     * 4. Add 1 -> temp = [1, 1, 1], steps = 0.
     *    - Add [1, 1, 1] to results.
     *    - Backtrack -> temp = [1, 1].
     * 5. Add 2 -> temp = [1, 1, 2], steps = -1.
     *    - Invalid path. Backtrack -> temp = [1, 1].
     *    - Backtrack -> temp = [1].
     * 6. Add 2 -> temp = [1, 2], steps = 0.
     *    - Add [1, 2] to results.
     *    - Backtrack -> temp = [1].
     *    - Backtrack -> temp = [].
     * 7. Add 2 -> temp = [2], steps = 1.
     * 8. Add 1 -> temp = [2, 1], steps = 0.
     *    - Add [2, 1] to results.
     *    - Backtrack -> temp = [2].
     *    - Backtrack -> temp = [].
     *
     * Final Results: [[1, 1, 1], [1, 2], [2, 1]]
     */
}
