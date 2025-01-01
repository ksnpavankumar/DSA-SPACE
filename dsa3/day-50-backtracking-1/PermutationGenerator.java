public class PermutationGenerator {
    private boolean[] visited;
    private ArrayList<ArrayList<Integer>> permutations;
    private ArrayList<Integer> inputArray;
    private int size;
    
    public ArrayList<ArrayList<Integer>> generatePermutations(ArrayList<Integer> inputArray) {
        size = inputArray.size();
        visited = new boolean[size];
        permutations = new ArrayList<>();
        this.inputArray = inputArray;
        explorePermutations(0, new ArrayList<>());
        return permutations;
    }

    public void explorePermutations(int index, ArrayList<Integer> tempPermutation) {
        if (index == size) {
            permutations.add(new ArrayList<>(tempPermutation));
            return;
        }
        // Try all possible elements for the current position
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tempPermutation.add(inputArray.get(i));
                explorePermutations(index + 1, tempPermutation);
                visited[i] = false;
                tempPermutation.remove(tempPermutation.size() - 1);
            }
        }
    }

    /*
    Example Execution for generating permutations of ["A", "B", "C"]:
    
    Initial state:
    inputArray = ["A", "B", "C"]
    size = 3 (length of inputArray)
    visited = [false, false, false]
    tempPermutation = [] (empty temporary list)
    
    Start with index = 0 (at position 0, the first element):
    - Try including "A":
        - tempPermutation = ["A"], index = 1
    
    Now at index = 1 (at position 1, second element):
    - Try including "B":
        - tempPermutation = ["A", "B"], index = 2
        
    Now at index = 2 (at position 2, third element):
    - Try including "C":
        - tempPermutation = ["A", "B", "C"] → Add this permutation to permutations: permutations = [["A", "B", "C"]]
    - Backtrack to explore excluding "C":
        - tempPermutation = ["A", "B"] → Backtrack.
        
    Backtrack to index = 1, and exclude "B":
    - Try including "C":
        - tempPermutation = ["A", "C"], index = 2
        - Try including "B":
            - tempPermutation = ["A", "C", "B"] → Add this permutation to permutations: permutations = [["A", "B", "C"], ["A", "C", "B"]]
        - Backtrack to explore excluding "B":
            - tempPermutation = ["A", "C"] → Backtrack.
    
    Backtrack to index = 0, and exclude "A":
    - Try including "B":
        - tempPermutation = ["B"], index = 1
        
    Now at index = 1 (at position 1, second element):
    - Try including "A":
        - tempPermutation = ["B", "A"], index = 2
        - Try including "C":
            - tempPermutation = ["B", "A", "C"] → Add this permutation to permutations: permutations = [["A", "B", "C"], ["A", "C", "B"], ["B", "A", "C"]]
        - Backtrack to explore excluding "C":
            - tempPermutation = ["B", "A"] → Backtrack.
    
    Backtrack to index = 1, and exclude "A":
    - Try including "C":
        - tempPermutation = ["B", "C"], index = 2
        - Try including "A":
            - tempPermutation = ["B", "C", "A"] → Add this permutation to permutations: permutations = [["A", "B", "C"], ["A", "C", "B"], ["B", "A", "C"], ["B", "C", "A"]]
        - Backtrack to explore excluding "A":
            - tempPermutation = ["B", "C"] → Backtrack.
    
    Backtrack to index = 0, and exclude "B":
    - Try including "C":
        - tempPermutation = ["C"], index = 1
        
    Now at index = 1 (at position 1, second element):
    - Try including "A":
        - tempPermutation = ["C", "A"], index = 2
        - Try including "B":
            - tempPermutation = ["C", "A", "B"] → Add this permutation to permutations: permutations = [["A", "B", "C"], ["A", "C", "B"], ["B", "A", "C"], ["B", "C", "A"], ["C", "A", "B"]]
        - Backtrack to explore excluding "B":
            - tempPermutation = ["C", "A"] → Backtrack.
    
    Backtrack to index = 1, and exclude "A":
    - Try including "B":
        - tempPermutation = ["C", "B"], index = 2
        - Try including "A":
            - tempPermutation = ["C", "B", "A"] → Add this permutation to permutations: permutations = [["A", "B", "C"], ["A", "C", "B"], ["B", "A", "C"], ["B", "C", "A"], ["C", "A", "B"], ["C", "B", "A"]]
        - Backtrack to explore excluding "A":
            - tempPermutation = ["C", "B"] → Backtrack.
    
    End of backtracking:
    - We have now explored all possible paths and the recursion ends.
    
    Final Permutations Collected:
    After all the recursive calls and backtracking, the permutations generated are:
    ["A", "B", "C"]
    ["A", "C", "B"]
    ["B", "A", "C"]
    ["B", "C", "A"]
    ["C", "A", "B"]
    ["C", "B", "A"]
    
    Summary of the Execution Flow:
    - At each step, the algorithm explores both including and excluding the current element at each index.
    - The backtracking process ensures that the algorithm tries every possible arrangement by going through all the combinations of elements.
    - Each time the algorithm reaches the end of the list (index == size), it adds the current permutation (tempPermutation) to the result (permutations).
    - The process continues recursively until all possible permutations are explored, ensuring that no possible combination is missed.
    
    This recursive backtracking approach explores all permutations by systematically building up a list (tempPermutation) of elements and adding/removing elements as needed, ensuring that all combinations are covered.
    */
}
