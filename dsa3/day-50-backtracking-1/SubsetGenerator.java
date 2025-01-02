import java.util.ArrayList;

public class SubsetGenerator {

    public ArrayList<ArrayList<Integer>> generateAllSubsets(ArrayList<Integer> inputList) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        findSubsets(inputList, 0, result, new ArrayList());
        return result;
    }

    public void findSubsets(ArrayList<Integer> inputList, int index, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentSubset) {
        // Base case: if we have considered all elements, add the current subset to the result
        if (index == inputList.size()) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        
        // Include the current element in the subset
        currentSubset.add(inputList.get(index)); // do 
        findSubsets(inputList, index + 1, result, currentSubset); // select 

        // Backtrack: remove the last added element to explore subsets without it
        currentSubset.remove(currentSubset.size() - 1); // undo

        // if we add currentSubset.add(inputList.get(index));  here then our code will fail, we are not adding
        // we are just increasing the index and moving.
        // Exclude the current element and move to the next element
        findSubsets(inputList, index + 1, result, currentSubset); // reject
    }

    public static void main(String[] args) {
        // Create an instance of SubsetGenerator
        SubsetGenerator generator = new SubsetGenerator();

        // Example 1: Input list [1, 2]
        ArrayList<Integer> input1 = new ArrayList<>();
        input1.add(1);
        input1.add(2);
        System.out.println("Subsets for input [1, 2]: " + generator.generateAllSubsets(input1));

        // Example 2: Input list [5, 10, 15]
        ArrayList<Integer> input2 = new ArrayList<>();
        input2.add(5);
        input2.add(10);
        input2.add(15);
        System.out.println("Subsets for input [5, 10, 15]: " + generator.generateAllSubsets(input2));

        // Example 3: Input list [1, 2, 3]
        ArrayList<Integer> input3 = new ArrayList<>();
        input3.add(1);
        input3.add(2);
        input3.add(3);
        System.out.println("Subsets for input [1, 2, 3]: " + generator.generateAllSubsets(input3));
    }
}

/**
 * Intuition for Generating Subsets:
 * 
 * This code generates **all subsets** (the power set) of a given list of integers using **backtracking**. 
 * For the input `[1, 2, 3]`, the output includes subsets of all sizes: `[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]`.
 *
 * Key Concepts:
 * 1. **Recursive Exploration**:
 *    - At each step, the recursion decides whether to include the current element or exclude it.
 *    - This forms a **binary decision tree**, where each node corresponds to a state of inclusion/exclusion for a specific index.
 *
 * 2. **Base Case**:
 *    - When the recursion reaches the end of the list (`index == A.size()`), the current subset (`temp`) is added to the result list.
 *
 * 3. **Backtracking**:
 *    - After exploring one path (e.g., including the current element), the algorithm **removes the last added element** and explores the other path (excluding the current element).
 *    - This ensures **all combinations** are explored.
 *
 * Step-by-Step Walkthrough for `[1, 2, 3]`:
 * 
 * 1. Start with an empty subset: `[]`.
 * 2. For each element, decide to include or exclude it:
 *    - Include `1` → `[1]`
 *    - Exclude `1` → `[]`
 * 
 * This process continues recursively for each subsequent element.
 *
 * Decision Tree for `[1, 2, 3]`:
 * 
 *                []
 *       Include 1 /    \ Exclude 1
 *              [1]       []
 *    Include 2 / \ Exclude 2    / \
 *          [1,2]   [1]      [2]   []
 * Include 3 / \ Exclude 3  / \  / \
 *    [1,2,3] [1,2] [1,3] [1] [2,3] [2] [3] []
 *
 * Output: `[[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]`
 *
 * Code Breakdown:
 * 1. **Initialization**:
 *    - `res` stores all subsets.
 *    - `temp` is a temporary list to build subsets.
 * 
 * 2. **Recursive Function**:
 *    - `temp.add(A.get(index))`: Add the current element and recurse to include it.
 *    - `temp.remove(temp.size() - 1)`: Backtrack by removing the last added element to explore the path that excludes it.
 *
 * 3. **Base Case**:
 *    - When `index == A.size()`, add the current subset (`temp`) to `res`.
 *
 * Time Complexity:
 * - **Number of Subsets**: \( 2^n \), where \( n \) is the size of the input list.
 * - **Work per Subset**: Adding subsets to `res` costs \( O(n) \).
 * - **Total Complexity**: \( O(n \cdot 2^n) \).
 *
 * Space Complexity:
 * - **Call Stack**: The depth of recursion is \( O(n) \).
 * - **Temporary List**: \( O(n) \).
 * - **Result Storage**: \( O(2^n \cdot n) \) for all subsets.
 */
