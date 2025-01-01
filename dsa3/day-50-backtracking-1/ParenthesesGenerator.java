import java.util.ArrayList;

public class ParenthesesGenerator {
    public static void main(String[] args) {
        ParenthesesGenerator generator = new ParenthesesGenerator();
        
        // Example inputs
        int A1 = 2;
        int A2 = 3;
        
        System.out.println("Generated Parentheses for A = " + A1 + ": " + generator.generateValidParentheses(A1));
        System.out.println("Generated Parentheses for A = " + A2 + ": " + generator.generateValidParentheses(A2));
    }

    /**
     * Generates all valid combinations of parentheses for a given number of pairs.
     * 
     * @param pairs The number of pairs of parentheses.
     * @return An ArrayList containing all valid combinations of parentheses.
     */
    public ArrayList<String> generateValidParentheses(int pairs) {
        ArrayList<String> result = new ArrayList<>();
        generateCombinations(result, "", pairs, pairs);
        return result;
    }

    /**
     * Recursive helper function to generate parentheses combinations.
     * 
     * @param result The list to store all valid combinations.
     * @param current The current string being built.
     * @param open The number of remaining open parentheses to add.
     * @param close The number of remaining close parentheses to add.
     */
    private void generateCombinations(ArrayList<String> result, String current, int open, int close) {
        // Base case: No more parentheses left to add
        if (open == 0 && close == 0) {
            result.add(current);
            return;
        }

        // Add an open parenthesis if any are left
        if (open > 0) {
            generateCombinations(result, current + "(", open - 1, close);
        }

        // Add a close parenthesis if it balances the parentheses
        if (close > open) {
            generateCombinations(result, current + ")", open, close - 1);
        }
    }
}

/*
 * Explanation and Intuition:
 * 
 * 1. The problem requires generating all valid combinations of balanced parentheses
 *    for a given number of pairs (A). For A=2, the result should be ["(())", "()()"].
 * 
 * 2. Key Idea:
 *    - A valid parentheses combination must always have more open '(' than close ')'
 *      at any point in the string.
 *    - Open parentheses can only be added if we have any left to place.
 *    - Close parentheses can only be added if their count is greater than the open ones
 *      to maintain balance.
 * 
 * 3. Recursive Process:
 *    - Start with an empty string ("") and recursively explore two options:
 *        a. Add '(' if open > 0.
 *        b. Add ')' if close > open.
 *    - Base case: When open == 0 and close == 0, a valid combination is complete.
 * 
 * 4. Example Walkthrough for A = 2:
 *    Input: generateCombinations("", 2, 2)
 * 
 *    Decision Tree:
 *    
 *          ""
 *         /  \
 *       "("   (invalid, cannot start with ")")
 *      /  \
 *    "(("   "()"
 *    /       \
 * "(())"    "()("
 *              \
 *             "()()"
 * 
 *    Explanation of Tree:
 *    - Start with "" (2 open, 2 close).
 *    - Add '(' → "(1 open, 2 close).
 *    - Add '(' → "((0 open, 2 close).
 *    - Add ')' → "(()(0 open, 1 close).
 *    - Add ')' → "(())(0 open, 0 close). Valid combination!
 *    - Backtrack to explore remaining paths, e.g., "()".
 * 
 * 5. Backtracking:
 *    - Once a valid path is explored, the recursion "backtracks" to explore other valid paths.
 *    - Backtracking ensures all combinations are explored systematically.
 * 
 * 6. Example Outputs:
 *    - For A = 2: ["(())", "()()"]
 *    - For A = 3: ["((()))", "(()())", "(())()", "()(())", "()()()"]
 * 
 * 7. Diagram for A = 2:
 * 
 *    generateCombinations("", 2, 2)
 *        ├── "(" -> generateCombinations("(", 1, 2)
 *        │       ├── "(" -> generateCombinations("((", 0, 2)
 *        │       │       ├── ")" -> generateCombinations("(()", 0, 1)
 *        │       │       │       ├── ")" -> generateCombinations("(())", 0, 0) [Add "(())"]
 *        │       │       └── Backtrack
 *        │       └── ")" -> generateCombinations("()", 1, 1)
 *        │               ├── "(" -> generateCombinations("()(", 0, 1)
 *        │               │       ├── ")" -> generateCombinations("()()", 0, 0) [Add "()()"]
 *        │               └── Backtrack
 *        └── Backtrack
 * 
 * Key Rules:
 * - Add '(' only if open > 0.
 * - Add ')' only if close > open.
 * - Base case: Add current to result if open == 0 and close == 0.
 */
