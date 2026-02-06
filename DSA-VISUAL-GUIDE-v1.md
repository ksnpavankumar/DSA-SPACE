# 📗 DSA Visual Guide v1 — Quick Reference

> **Concise quick-reference version** with small visuals, complexity analysis, and key intuition bullets for interview prep.

---

## Table of Contents

**Linked Lists**
- [1. Reverse Linked List](#1-reverse-linked-list)
- [2. Find Middle of Linked List](#2-find-middle-of-linked-list)

**Stacks**
- [3. Ball Possession (Stack Simulation)](#3-ball-possession-stack-simulation)

**Two Pointers**
- [4. Container With Most Water](#4-container-with-most-water)
- [5. Subarray Sum Finder](#5-subarray-sum-finder)
- [6. Pair Difference Finder](#6-pair-difference-finder)
- [7. Pair Difference Counter](#7-pair-difference-counter)
- [8. Pair Sum Counter](#8-pair-sum-counter)
- [9. Rectangle Area Counter](#9-rectangle-area-counter)

**Backtracking**
- [10. Parentheses Generator](#10-parentheses-generator)
- [11. Subset Generator](#11-subset-generator)
- [12. Permutation Generator](#12-permutation-generator)
- [13. Staircase Combinations](#13-staircase-combinations)

**Heaps & Priority Queues**
- [14. Min Heap Builder](#14-min-heap-builder)
- [15. Kth Largest Element](#15-kth-largest-element)
- [16. K Sorted Array Handler](#16-k-sorted-array-handler)
- [17. Sort Nearly Sorted Array](#17-sort-nearly-sorted-array)
- [18. Meeting Rooms](#18-meeting-rooms)
- [19. Merge K Sorted Lists](#19-merge-k-sorted-lists)

**Dynamic Programming (1D)**
- [20. Fibonacci DP](#20-fibonacci-dp)
- [21. Climbing Stairs](#21-climbing-stairs)
- [22. Min Perfect Squares](#22-min-perfect-squares)

**Knapsack Problems**
- [23. Fractional Knapsack](#23-fractional-knapsack)
- [24. 0/1 Knapsack](#24-01-knapsack)
- [25. Unbounded Knapsack](#25-unbounded-knapsack)
- [26. Rod Cutting](#26-rod-cutting)

**Graphs**
- [27. Graph DFS (Depth-First Search)](#27-graph-dfs-depth-first-search)
- [28. Graph BFS (Breadth-First Search)](#28-graph-bfs-breadth-first-search)
- [29. Rotten Oranges](#29-rotten-oranges)

**Summary**
- [Algorithm Comparison Table](#algorithm-comparison-table)

---

## Linked Lists

### 1. Reverse Linked List
📁 `ReverseLinkedList.java` · `ReverseLinkedList.py` | 🌿 DSA3

Reverse all pointers in a singly linked list using 3 pointers in one pass.

```
NULL ◄── 1 ◄── 2 ◄── 3 ◄── 4 (new head)
```

⏱ **Time:** O(n) | **Space:** O(1)

💡 **Key Intuition:**
- Save `next` before flipping pointer, or you lose the rest of the list
- Three pointers: `prev`, `curr`, `next` — like re-coupling train carriages
- Edge case: empty list or single node → return as-is

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#1-reverse-linked-list)

---

### 2. Find Middle of Linked List
📁 `LinkedListMiddle.java` · `LinkedListMiddle.py` | 🌿 DSA3

Find the middle node using slow-fast pointer technique (Floyd's Tortoise and Hare).

```
Slow: 1 → 2 → 3
Fast: 1 → 3 → 5 → null
      ↑middle
```

⏱ **Time:** O(n) | **Space:** O(1)

💡 **Key Intuition:**
- Fast pointer moves 2x speed; when it reaches end, slow is at middle
- For even-length lists, returns second middle node
- No need to count nodes first — single traversal

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#2-find-middle-of-linked-list)

---

## Stacks

### 3. Ball Possession (Stack Simulation)
📁 `StackProcessor.java` · `BallPossession.py` | 🌿 DSA3

Simulate ball passing using a stack: forward pass pushes, backward pass (0) pops.

```
Stack: [B] → [B,1] → [B,1,2] → [B,1] → [B,1,3] → [B,1,3,4]
Pass:   B      1        2        0        3         4
Result: 4
```

⏱ **Time:** O(n) | **Space:** O(n)

💡 **Key Intuition:**
- Stack naturally tracks "who passed to whom" (call stack analogy)
- Zero means "pass back to previous player" → pop
- Top of stack = current ball holder

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#3-ball-possession-stack-simulation)

---

## Two Pointers

### 4. Container With Most Water
📁 `ContainerWithMostWater.java` · `ContainerWithMostWater.py` | 🌿 DSA3

Find two lines that form container with maximum water area using two pointers.

```
height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
         L                       R
Area = min(8,7) × 8 = 56 → shrink shorter side
```

⏱ **Time:** O(n) | **Space:** O(1)

💡 **Key Intuition:**
- Width always decreases, so only increase height by moving shorter line
- Greedy: moving taller pointer can never improve area
- Two pointers converge from outside to inside

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#4-container-with-most-water)

---

### 5. Subarray Sum Finder
📁 `SubarraySumFinder.java` · `SubarraySumFinder.py` | 🌿 DSA3

Find contiguous subarray with target sum using sliding window.

```
[1, 2, 3, 4, 5], target=9
 i        j
sum=1+2+3+4=10 > 9 → shrink left
   i     j
sum=2+3+4=9 ✓
```

⏱ **Time:** O(n) | **Space:** O(1)

💡 **Key Intuition:**
- Expand window (j++) while sum < target
- Shrink window (i++) while sum > target
- Works only for positive numbers (monotonic sum)

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#5-subarray-sum-finder)

---

### 6. Pair Difference Finder
📁 `PairDifferenceFinder.java` | 🌿 DSA3

Count distinct pairs (x,y) where |x-y| = target, using sorted array + two pointers.

```
[1, 2, 3, 4, 5], target=2
 L  R
diff=2-1=1 < 2 → move R
 L     R
diff=3-1=2 ✓ → count pair (1,3)
```

⏱ **Time:** O(n log n) | **Space:** O(1)

💡 **Key Intuition:**
- Sort first to enable controlled pointer movement
- Increase diff by moving right pointer, decrease by moving left
- Skip duplicates to count only distinct pairs

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#6-pair-difference-finder)

---

### 7. Pair Difference Counter
📁 `PairDifferenceCounter.java` | 🌿 DSA3

Count distinct pairs with target difference using HashSet (unsorted array).

```
For each num, check if (num+diff) or (num-diff) exists in set
[1, 5, 3, 4, 2], diff=2
Check 1: 3 in set? Not yet
Check 5: 3,7 in set? 3✓ → pair (3,5)
```

⏱ **Time:** O(n) | **Space:** O(n)

💡 **Key Intuition:**
- HashSet allows O(1) lookups — faster than sorting for small ranges
- Store pairs as strings to avoid duplicates: "min:max"
- Trade space for time compared to two-pointer approach

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#7-pair-difference-counter)

---

### 8. Pair Sum Counter
📁 `PairSumCounter.java` | 🌿 DSA3

Count pairs in sorted array with target sum, handling duplicates carefully.

```
[1, 2, 2, 3, 4], target=5
 L           R
sum=1+4=5 ✓
If L==R element-wise: nC2 pairs
Else: count(L) × count(R) pairs
```

⏱ **Time:** O(n) | **Space:** O(1)

💡 **Key Intuition:**
- When elements equal, use combination formula: n×(n-1)/2
- For different elements, multiply their frequencies
- Move pointers based on sum comparison (like binary search)

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#8-pair-sum-counter)

---

### 9. Rectangle Area Counter
📁 `RectangleAreaCounter.java` | 🌿 DSA3

Count rectangles with area < target using sorted distinct sides.

```
[1, 2, 3, 4, 5], maxArea=5
 L           R
1×5=5 ≥ 5 → R--
 L        R
1×4=4 < 5 ✓ → all (L,0..R) valid → count 4
```

⏱ **Time:** O(n) | **Space:** O(1)

💡 **Key Intuition:**
- If L×R < max, then L pairs with all elements from start to R
- Sorted array allows greedy counting without checking each pair
- Similar to container problem but counting instead of maximizing

�� [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#9-rectangle-area-counter)

---

## Backtracking

### 10. Parentheses Generator
📁 `ParenthesesGenerator.java` | 🌿 DSA3

Generate all valid n-pair parentheses combinations using backtracking.

```
n=2: ["(())", "()()"]
      ""
     /
   "("
   / \
"((" "()"
```

⏱ **Time:** O(4^n / √n) Catalan | **Space:** O(n)

💡 **Key Intuition:**
- Add '(' if open < n; add ')' if close < open (maintain balance)
- Backtrack after exploring each branch
- Never have more ')' than '(' at any point

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#10-parentheses-generator)

---

### 11. Subset Generator
📁 `SubsetGenerator.java` | 🌿 DSA3

Generate all subsets (power set) using backtracking — include/exclude decisions.

```
[1,2]: [[], [1], [2], [1,2]]
        []
      /    \
   [1]      []
   / \      / \
[1,2] [1] [2] []
```

⏱ **Time:** O(2^n × n) | **Space:** O(n)

💡 **Key Intuition:**
- Binary tree: each node decides include/exclude current element
- 2^n total subsets (each element in or out)
- Backtracking adds element, recurses, then removes for next path

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#11-subset-generator)

---

### 12. Permutation Generator
📁 `PermutationGenerator.java` | 🌿 DSA3

Generate all permutations using backtracking with visited array.

```
[A,B,C]: ["ABC","ACB","BAC","BCA","CAB","CBA"]
At each position, try all unvisited elements
```

⏱ **Time:** O(n × n!) | **Space:** O(n)

💡 **Key Intuition:**
- Fix first position, permute rest; then fix second position, etc.
- Visited array tracks used elements in current path
- n! permutations total (factorial growth)

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#12-permutation-generator)

---

### 13. Staircase Combinations
📁 `StaircaseCombinations.java` | 🌿 DSA3

Find all ways to climb n stairs taking 1 or 2 steps at a time.

```
n=3: [[1,1,1], [1,2], [2,1]]
       3
      / \
   -1/   \-2
    2     1
   / \   / \
  1   0 -1  0
 / \   
0  -1  
```

⏱ **Time:** O(2^n) | **Space:** O(n)

💡 **Key Intuition:**
- Binary decision tree: take 1 step or 2 steps
- Base case: steps=0 (success), steps<0 (invalid)
- Similar to Fibonacci but tracking actual paths

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#13-staircase-combinations)

---

## Heaps & Priority Queues

### 14. Min Heap Builder
📁 `MinHeapBuilder.java` | 🌿 DSA4

Build min-heap from array using bottom-up heapify (in-place).

```
[3,5,1,10,2,7] → [1,2,3,10,5,7]
      1
     / \
    2   3
   / \ /
  10 5 7
```

⏱ **Time:** O(n) | **Space:** O(1)

💡 **Key Intuition:**
- Start from last parent (n/2-1) and heapify downwards
- O(n) because most nodes are leaves (no heapify needed)
- Parent always smaller than children (min-heap property)

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#14-min-heap-builder)

---

### 15. Kth Largest Element
📁 `KthLargestElement.java` | 🌿 DSA4

Find Kth largest for each subarray [1..i] using min-heap of size K.

```
[4,2,7,1,5,3], K=3
Heap after i=2 (K-1): [-1,-1,2]
i=3: heap=[2,4,7], result=2 (3rd largest)
i=4: 1 < 2, no change, result=4
```

⏱ **Time:** O(n log k) | **Space:** O(k)

💡 **Key Intuition:**
- Min-heap of size K keeps top K largest; root = Kth largest
- Heap size < K → return -1
- If new element > root, replace root and heapify

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#15-kth-largest-element)

---

### 16. K Sorted Array Handler
📁 `KSortedArrayHandler.java` | 🌿 DSA4

Sort K-sorted array (each element at most K positions from correct place) using heap.

```
[6,5,3,2,8,10,9], K=2
Heap: [3,5,6] → pop 3 → [5,6,8] → pop 5...
Result: [2,3,5,6,8,9,10]
```

⏱ **Time:** O(n log k) | **Space:** O(k)

💡 **Key Intuition:**
- Min-heap of size K+1 ensures smallest element is in correct range
- Sliding window: add new, extract min, shift window
- Much faster than full sort O(n log n) when K << n

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#16-k-sorted-array-handler)

---

### 17. Sort Nearly Sorted Array
📁 `SortNearlySortedArray.java` | 🌿 DSA4

Same as K Sorted Array Handler — sort array where elements are at most K positions away.

```
Same algorithm as #16
Works because smallest element must be in first K+1 positions
```

⏱ **Time:** O(n log k) | **Space:** O(k)

💡 **Key Intuition:**
- Identical to K Sorted Array Handler
- Interview tip: these are the same problem with different names
- Remember: "nearly sorted" = "K-sorted" = "almost sorted"

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#17-sort-nearly-sorted-array)

---

### 18. Meeting Rooms
📁 `MeetingRooms.java` | 🌿 DSA4

Find minimum meeting rooms needed using difference array technique.

```
Meetings: [(0,30), (5,10), (15,20)]
Timeline: [0:+1, 5:+1, 10:-1, 15:+1, 20:-1, 30:-1]
Prefix:   [0:1,  5:2,  10:1,  15:2,  20:1,  30:0]
Max = 2 rooms
```

⏱ **Time:** O(n + maxTime) | **Space:** O(maxTime)

💡 **Key Intuition:**
- Mark +1 at start, -1 at end → prefix sum = active meetings
- Max of prefix sum = peak room usage
- Alternative: sort starts/ends separately (sweep line)

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#18-meeting-rooms)

---

### 19. Merge K Sorted Lists
📁 `MergeKSortedLists.java` | 🌿 DSA4

Merge K sorted linked lists using min-heap.

```
Lists: [1→4→5], [1→3→4], [2→6]
Heap: [1(L1), 1(L2), 2(L3)]
Pop 1(L1), add 4(L1) → merged: 1→
Pop 1(L2), add 3(L2) → merged: 1→1→
```

⏱ **Time:** O(N log k), N=total nodes | **Space:** O(k)

💡 **Key Intuition:**
- Heap holds one node from each list (K elements)
- Always extract min, add its next node to heap
- Better than merging pairs repeatedly: O(N log k) vs O(Nk)

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#19-merge-k-sorted-lists)

---

## Dynamic Programming (1D)

### 20. Fibonacci DP
📁 `FibonacciDP.java` | 🌿 DSA4

Compute Nth Fibonacci using bottom-up DP array.

```
fib(5):
dp = [0, 1, 1, 2, 3, 5]
      0  1  2  3  4  5
dp[i] = dp[i-1] + dp[i-2]
```

⏱ **Time:** O(n) | **Space:** O(n)

💡 **Key Intuition:**
- Store subproblem results to avoid recalculation (memoization)
- Can optimize to O(1) space using only two variables
- Base cases: fib(0)=0, fib(1)=1

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#20-fibonacci-dp)

---

### 21. Climbing Stairs
📁 `ClimbingStairs.java` | 🌿 DSA4

Count ways to climb n stairs taking 1 or 2 steps (Fibonacci variant).

```
n=4:
ways(4) = ways(3) + ways(2)
        = 3 + 2 = 5
Paths: [1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2]
```

⏱ **Time:** O(n) | **Space:** O(1)

💡 **Key Intuition:**
- Same as Fibonacci: ways(n) = ways(n-1) + ways(n-2)
- From n-1 stair: take 1 step; from n-2 stair: take 2 steps
- Use mod 10^9+7 to prevent overflow

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#21-climbing-stairs)

---

### 22. Min Perfect Squares
📁 `MinPerfectSquares.java` | 🌿 DSA4

Find minimum number of perfect squares that sum to n.

```
n=12:
dp[12] = min(dp[12-1²]+1, dp[12-2²]+1, dp[12-3²]+1)
       = min(dp[11]+1, dp[8]+1, dp[3]+1)
       = 3 (4+4+4)
```

⏱ **Time:** O(n√n) | **Space:** O(n)

💡 **Key Intuition:**
- Try all perfect squares ≤ n, pick minimum
- dp[i] = min over all j² ≤ i of (dp[i-j²] + 1)
- Greedy doesn't work: 12 ≠ 9+1+1+1 but 4+4+4

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#22-min-perfect-squares)

---

## Knapsack Problems

### 23. Fractional Knapsack
📁 `KnapSack.java` | 🌿 DSA4

Maximize value taking fractional items using greedy (value/weight ratio).

```
Items: v=[60,100,120], w=[10,20,30], cap=50
Ratio: [6, 5, 4]
Take: 10kg@6 + 20kg@5 + 20kg@4 = 60+100+80=240
```

⏱ **Time:** O(n log n) | **Space:** O(n)

💡 **Key Intuition:**
- Sort by value/weight ratio descending
- Greedy works because we can take fractions
- Take highest ratio items until capacity full

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#23-fractional-knapsack)

---

### 24. 0/1 Knapsack
📁 `KnapsackHappinessOneDimArray.java` · `KnapsackHappinessTwoDimArray.java` | 🌿 DSA4

Maximize value taking whole items using DP (can't take fractions).

```
dp[i][w] = max(
  dp[i-1][w],              // skip item i
  dp[i-1][w-wt[i]] + val[i] // take item i
)
```

⏱ **Time:** O(nW) | **Space:** O(nW) or O(W)

💡 **Key Intuition:**
- Can't use greedy (fractions not allowed)
- DP: for each item, decide take or skip
- Can optimize to 1D array by iterating backwards

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#24-01-knapsack)

---

### 25. Unbounded Knapsack
📁 `UnboundedKnapsackMaxValue.java` | 🌿 DSA4

Maximize value with unlimited quantity of each item.

```
dp[w] = max over all items i of (dp[w-wt[i]] + val[i])
Can take same item multiple times
```

⏱ **Time:** O(nW) | **Space:** O(W)

💡 **Key Intuition:**
- Similar to 0/1 but can reuse items
- Forward iteration (unlike 0/1 which goes backward)
- Applications: coin change, rod cutting

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#25-unbounded-knapsack)

---

### 26. Rod Cutting
📁 `RodCutting.py` · `RodCuttingSolver.java` | 🌿 DSA4

Maximize profit cutting rod into pieces (unbounded knapsack variant).

```
prices=[1,5,8,9,10,17,17,20], len=8
dp[8] = max(p[0]+dp[7], p[1]+dp[6], ..., p[7]+dp[0])
      = max(1+18, 5+17, 8+14, ...) = 22
Cuts: 2+6 (5+17)
```

⏱ **Time:** O(n²) | **Space:** O(n)

💡 **Key Intuition:**
- Try all possible first cuts, recurse on remainder
- Same structure as unbounded knapsack
- Can reconstruct cuts by storing decisions

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#26-rod-cutting)

---

## Graphs

### 27. Graph DFS (Depth-First Search)
📁 `Graph.java` | 🌿 DSA4

Traverse graph depth-first using recursion and visited array.

```
   0 → 1
   ↓   ↓
   2 → 3
DFS(2): 2 → 0 → 1 → 3
```

⏱ **Time:** O(V+E) | **Space:** O(V)

💡 **Key Intuition:**
- Go as deep as possible before backtracking
- Recursive: mark visited, recurse on neighbors
- Applications: cycle detection, topological sort, pathfinding

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#27-graph-dfs-depth-first-search)

---

### 28. Graph BFS (Breadth-First Search)
📁 `GraphBFS.java` · `GraphBFS.py` | 🌿 DSA4

Traverse graph level-by-level using queue.

```
   0
  / \
 1   2
/ \ / \
3 4 5 6
BFS(0): 0 → 1 → 2 → 3 → 4 → 5 → 6
```

⏱ **Time:** O(V+E) | **Space:** O(V)

💡 **Key Intuition:**
- Process level by level (like tree level-order)
- Queue for FIFO processing
- Finds shortest path in unweighted graphs

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#28-graph-bfs-breadth-first-search)

---

### 29. Rotten Oranges
📁 `RottenOranges.java` · `RottenOranges.py` | 🌿 DSA4

Find minimum time for all oranges to rot using multi-source BFS.

```
Initial:  2 1 1     After 1:  2 2 1     After 2:  2 2 2
          1 1 0              2 1 0                2 2 0
          0 1 1              0 1 1                0 2 1
```

⏱ **Time:** O(rows × cols) | **Space:** O(rows × cols)

💡 **Key Intuition:**
- Multi-source BFS: start with all rotten oranges in queue
- Each minute = one BFS level (4-directional spread)
- If any fresh orange remains → return -1

👉 [Detailed explanation →](DSA-VISUAL-GUIDE-v2.md#29-rotten-oranges)

---

## Algorithm Comparison Table

| # | Algorithm | Time | Space | Technique | When to Use |
|---|-----------|------|-------|-----------|-------------|
| 1 | Reverse Linked List | O(n) | O(1) | Three Pointers | Reverse in-place, no extra space |
| 2 | Find Middle LL | O(n) | O(1) | Slow-Fast Pointers | Find middle without counting |
| 3 | Ball Possession | O(n) | O(n) | Stack | Track forward/backward operations |
| 4 | Container Water | O(n) | O(1) | Two Pointers | Max area between lines |
| 5 | Subarray Sum | O(n) | O(1) | Sliding Window | Contiguous sum (positive nums) |
| 6 | Pair Difference (Sorted) | O(n log n) | O(1) | Two Pointers | Sorted + pair difference |
| 7 | Pair Difference (Hash) | O(n) | O(n) | HashSet | Unsorted + pair difference |
| 8 | Pair Sum | O(n) | O(1) | Two Pointers | Sorted + pair sum |
| 9 | Rectangle Area | O(n) | O(1) | Two Pointers | Count pairs with product < X |
| 10 | Parentheses Gen | O(4^n/√n) | O(n) | Backtracking | Generate valid combinations |
| 11 | Subset Gen | O(2^n·n) | O(n) | Backtracking | Power set generation |
| 12 | Permutation Gen | O(n·n!) | O(n) | Backtracking | All orderings |
| 13 | Staircase Comb | O(2^n) | O(n) | Backtracking | All paths (1 or 2 steps) |
| 14 | Min Heap Build | O(n) | O(1) | Heapify | Build heap in-place |
| 15 | Kth Largest | O(n log k) | O(k) | Min-Heap | Top K elements |
| 16-17 | K-Sorted Array | O(n log k) | O(k) | Min-Heap | Nearly sorted array |
| 18 | Meeting Rooms | O(n+T) | O(T) | Difference Array | Overlapping intervals |
| 19 | Merge K Lists | O(N log k) | O(k) | Min-Heap | Merge sorted streams |
| 20 | Fibonacci DP | O(n) | O(n) | 1D DP | Overlapping subproblems |
| 21 | Climbing Stairs | O(n) | O(1) | 1D DP | Count ways (Fibonacci) |
| 22 | Min Squares | O(n√n) | O(n) | 1D DP | Sum of perfect squares |
| 23 | Fractional Knap | O(n log n) | O(n) | Greedy | Fractions allowed |
| 24 | 0/1 Knapsack | O(nW) | O(W) | 2D DP | Whole items only |
| 25 | Unbounded Knap | O(nW) | O(W) | 1D DP | Unlimited items |
| 26 | Rod Cutting | O(n²) | O(n) | 1D DP | Maximize cuts |
| 27 | Graph DFS | O(V+E) | O(V) | DFS | Explore all paths |
| 28 | Graph BFS | O(V+E) | O(V) | BFS | Shortest path (unweighted) |
| 29 | Rotten Oranges | O(r·c) | O(r·c) | Multi-BFS | Multi-source spread |

**Legend:**
- n = array/list size
- k = window/heap size
- W = knapsack capacity
- V = vertices, E = edges
- r,c = rows, cols

---

**Need more details?** 👉 Check out the [Deep Dive Guide (v2)](DSA-VISUAL-GUIDE-v2.md) for complete walkthroughs!

