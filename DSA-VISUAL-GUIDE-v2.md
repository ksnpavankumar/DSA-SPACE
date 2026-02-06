# 📘 DSA Visual Guide v2 — Deep Dive

> **Detailed deep-dive version** with full explanations, extensive ASCII visuals, intuition blocks, and walkthroughs.

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

**Summaries**
- [Algorithm Comparison Table](#algorithm-comparison-table)
- [Technique Relationship Map](#technique-relationship-map)
- [When to Use What — Decision Guide](#when-to-use-what--decision-guide)

---

## Linked Lists

### 1. Reverse Linked List

📁 **Files:** 
- [ReverseLinkedList.java](https://github.com/ksnpavankumar/DSA-SPACE/blob/DSA3/dsa3/day-36-linkedlist/ReverseLinkedList.java)
- [ReverseLinkedList.py](https://github.com/ksnpavankumar/DSA-SPACE/blob/DSA3/dsa3/day-36-linkedlist/ReverseLinkedList.py)

🌿 **Branch:** DSA3

#### 🧠 Concept

Reversing a singly linked list means changing the direction of all `next` pointers so that the list traversal order is reversed. The last node becomes the head, and the original head becomes the tail (pointing to null). This must be done in-place using O(1) extra space, meaning we can't create a new list or use recursion with O(n) stack space.

Use this when you need to reverse a list in one pass without auxiliary data structures — common in linked list manipulation problems and as a building block for more complex algorithms.

#### 💡 Intuition Points

> **Mental Model:** Think of it like re-coupling train carriages. You need to:
> 1. Remember the next carriage before changing the coupling
> 2. Turn the current carriage around to point backwards
> 3. Move to the next carriage and repeat

> **Why three pointers work:** 
> - `prev`: tracks the reversed portion (where we're pointing back to)
> - `current`: the node we're currently reversing
> - `next`: saves the rest of the list before we lose the reference

> **Key insight:** If you flip `current.next = prev` without saving `next`, you lose access to the rest of the list. That's why we must save it first with `next = current.next`.

> **Interview tip:** Always handle edge cases first: null list and single-node list both return immediately without modification.

> **Common mistake:** Forgetting to move `prev` forward causes an infinite loop. The sequence must be: save next, flip pointer, advance prev, advance current.

> **When this fails:** If you need to preserve the original list, you must create a copy first. In-place reversal destroys the original order.

#### 🔄 Visual Walkthrough

**Initial state:** Reverse list `1 → 2 → 3 → 4 → null`

```
Step 0: Initialize
prev = null
current = 1 → 2 → 3 → 4 → null
next = undefined

Step 1: Process node 1
next = current.next        [Save 2 → 3 → 4]
     = 2 → 3 → 4 → null

current.next = prev        [Flip pointer to null]
     null ← 1

prev = current             [Move prev forward]
     = 1 → null

current = next             [Move to next node]
        = 2 → 3 → 4 → null

Visual: null ← 1    2 → 3 → 4 → null
             prev  curr

Step 2: Process node 2
next = 3 → 4 → null
current.next = prev
     null ← 1 ← 2
prev = 2
current = 3 → 4 → null

Visual: null ← 1 ← 2    3 → 4 → null
                  prev  curr

Step 3: Process node 3
next = 4 → null
current.next = prev
     null ← 1 ← 2 ← 3
prev = 3
current = 4 → null

Visual: null ← 1 ← 2 ← 3    4 → null
                       prev  curr

Step 4: Process node 4
next = null
current.next = prev
     null ← 1 ← 2 ← 3 ← 4
prev = 4
current = null

Visual: null ← 1 ← 2 ← 3 ← 4    null
                            prev  curr

Step 5: Loop ends (current == null)
Return prev (which is the new head)

Final result: null ← 1 ← 2 ← 3 ← 4
              (read right-to-left: 4 → 3 → 2 → 1 → null)
```

#### ⏱ Complexity Table

| | Value | Why |
|---|---|---|
| **Time** | O(n) | Single pass through all n nodes; each node processed exactly once |
| **Space** | O(1) | Only three pointer variables used; no recursion or auxiliary structures |

#### 🔗 Related Problems

- **LeetCode 206:** Reverse Linked List (exact same problem)
- **LeetCode 92:** Reverse Linked List II (reverse only between positions m and n)
- **LeetCode 25:** Reverse Nodes in k-Group (reverse every k nodes)

[⬆ Back to top](#table-of-contents)

---

### 2. Find Middle of Linked List

📁 **Files:**
- [LinkedListMiddle.java](https://github.com/ksnpavankumar/DSA-SPACE/blob/DSA3/dsa3/day-37-ll2/LinkedListMiddle.java)
- [LinkedListMiddle.py](https://github.com/ksnpavankumar/DSA-SPACE/blob/DSA3/dsa3/day-37-ll2/LinkedListMiddle.py)

🌿 **Branch:** DSA3

#### 🧠 Concept

Finding the middle node of a linked list using the slow-fast pointer technique (also called Floyd's Tortoise and Hare algorithm). The slow pointer moves one step at a time while the fast pointer moves two steps. When the fast pointer reaches the end, the slow pointer will be at the middle. For even-length lists, this returns the second middle node.

This technique is fundamental because it finds the middle in O(1) space without needing to count the total length first.

#### 💡 Intuition Points

> **Analogy:** Imagine two runners on a circular track where one runs twice as fast. When the fast runner completes the lap, the slow runner is exactly halfway around.

> **Why it works:** If fast pointer moves 2x speed and starts at the same position, by the time it reaches the end (n steps), slow has traveled n/2 steps — exactly the middle.

> **For even-length lists:** When the list has an even number of nodes (e.g., 4 nodes), there are two middle nodes (nodes 2 and 3). This algorithm returns the second middle (node 3) because `fast.next != null` allows one more slow step.

> **Interview follow-up:** "How would you get the first middle for even-length lists?" Answer: Check `fast.next.next != null` instead of `fast.next != null`.

> **Common mistake:** Initializing pointers differently (e.g., fast starting at head.next) changes which middle you get. Stick to both starting at head for consistency.

> **Edge cases:** Single-node list returns that node. Empty list should be handled before the algorithm (return null or raise exception).

#### 🔄 Visual Walkthrough

**Example 1: Odd-length list** `1 → 2 → 3 → 4 → 5 → null`

```
Initial:
slow = fast = 1
List: 1 → 2 → 3 → 4 → 5 → null
      ↑
    s,f

Iteration 1:
slow moves 1 step: slow = 2
fast moves 2 steps: fast = 3
List: 1 → 2 → 3 → 4 → 5 → null
          ↑   ↑
          s   f

Iteration 2:
slow moves 1 step: slow = 3
fast moves 2 steps: fast = 5
List: 1 → 2 → 3 → 4 → 5 → null
              ↑       ↑
              s       f

Iteration 3:
fast.next = null, so loop terminates
Return slow = 3 ✓ (middle node)
```

**Example 2: Even-length list** `1 → 2 → 3 → 4 → null`

```
Initial:
slow = fast = 1
List: 1 → 2 → 3 → 4 → null
      ↑
    s,f

Iteration 1:
slow = 2, fast = 3
List: 1 → 2 → 3 → 4 → null
          ↑   ↑
          s   f

Iteration 2:
slow = 3, fast.next = null (fast at 4)
List: 1 → 2 → 3 → 4 → null
              ↑   ↑
              s   f

Loop terminates
Return slow = 3 ✓ (second middle node)
```

**Example 3: Two-node list** `1 → 2 → null`

```
Initial: slow = fast = 1
Iteration 1: slow = 2, fast = null
Return slow = 2 ✓
```

#### ⏱ Complexity Table

| | Value | Why |
|---|---|---|
| **Time** | O(n) | Fast pointer traverses entire list (n nodes), slow traverses half (n/2) |
| **Space** | O(1) | Only two pointer variables; no recursion or data structures |

#### 🔗 Related Problems

- **LeetCode 876:** Middle of the Linked List (exact same)
- **LeetCode 234:** Palindrome Linked List (uses middle finding as first step)
- **LeetCode 143:** Reorder List (find middle, reverse second half, merge)

[⬆ Back to top](#table-of-contents)

---

### 3. Ball Possession (Stack Simulation)

📁 **Files:**
- [StackProcessor.java](https://github.com/ksnpavankumar/DSA-SPACE/blob/DSA3/dsa3/day-40-stack/StackProcessor.java)
- [BallPossession.py](https://github.com/ksnpavankumar/DSA-SPACE/blob/DSA3/dsa3/day-40-stack/BallPossession.py)

🌿 **Branch:** DSA3

#### 🧠 Concept

This problem simulates ball passing in a football game using a stack data structure. Initially, player B has the ball. For each pass in array C:
- If C[i] > 0: player passes ball forward to player with ID = C[i] (push to stack)
- If C[i] = 0: current player passes ball back to the previous player (pop from stack)

The top of the stack always represents the current ball holder. This is a classic stack simulation problem that models the "forward and backward" pattern.

#### 💡 Intuition Points

> **Mental model:** Think of a stack of plates. Each forward pass adds a new plate (player) on top. A backward pass (0) removes the top plate, revealing the previous player underneath.

> **Why stack is perfect:** The Last-In-First-Out (LIFO) property naturally handles "pass back" operations. You always pass back to the most recent person who passed to you.

> **Real-world analogy:** Like a function call stack in programming — when a function returns (backward pass), control goes back to the caller (previous player).

> **Key insight:** You don't need to track the full history of passes, just the current "chain" of possession. The stack implicitly maintains this chain.

> **Interview follow-up:** "What if a player passes back when stack is empty?" Answer: The code checks `!stack.isEmpty()` before popping to prevent errors.

> **Edge case:** If all passes are backwards (all zeros) and we pop everything, the stack could be empty. Return -1 in this case.

#### 🔄 Visual Walkthrough

**Example:** A=5, B=2, C=[1, 2, 0, 3, 4]

```
Initial State:
Stack: [2]         (Player 2 starts with ball)
Current ball holder: 2

Pass 1: C[0] = 1 (forward pass to player 1)
Action: Push 1
Stack: [2, 1]
Ball holder: 1

Pass 2: C[1] = 2 (forward pass to player 2)
Action: Push 2
Stack: [2, 1, 2]
Ball holder: 2 (different from base player 2!)

Pass 3: C[2] = 0 (backward pass)
Action: Pop
Stack: [2, 1]
Ball holder: 1 (back to player 1)

Pass 4: C[3] = 3 (forward pass to player 3)
Action: Push 3
Stack: [2, 1, 3]
Ball holder: 3

Pass 5: C[4] = 4 (forward pass to player 4)
Action: Push 4
Stack: [2, 1, 3, 4]
Ball holder: 4

Final Answer: Top of stack = 4
```

**Visual representation of stack changes:**

```
Pass:    Init    1       2       3       4       5
Stack:   [2]     [2]     [2]     [2]     [2]     [2]
                 [1]     [1]     [1]     [1]     [1]
                        [2]             [3]     [3]
                                               [4]
Top:      2       1       2       1       3       4
```

**Another example:** A=4, B=5, C=[0, 0, 0, 0] (all backwards)

```
Initial: Stack [5]
Pass 1 (0): Pop → Stack []
Pass 2 (0): Pop → Stack empty, no action
Pass 3 (0): Pop → Stack empty, no action
Pass 4 (0): Pop → Stack empty, no action

Result: -1 (stack is empty)
```

#### ⏱ Complexity Table

| | Value | Why |
|---|---|---|
| **Time** | O(n) | Process each of n passes exactly once; push/pop are O(1) operations |
| **Space** | O(n) | Worst case: all forward passes, stack contains n elements |

#### 🔗 Related Problems

- **LeetCode 844:** Backspace String Compare (similar backward operation concept)
- **LeetCode 1021:** Remove Outermost Parentheses (stack-based parentheses matching)
- **LeetCode 946:** Validate Stack Sequences (simulate stack push/pop operations)

[⬆ Back to top](#table-of-contents)

---

### 4. Container With Most Water

📁 **Files:**
- [ContainerWithMostWater.java](https://github.com/ksnpavankumar/DSA-SPACE/blob/DSA3/dsa3/day-49-two-pointers/ContainerWithMostWater.java)
- [ContainerWithMostWater.py](https://github.com/ksnpavankumar/DSA-SPACE/blob/DSA3/dsa3/day-49-two-pointers/ContainerWithMostWater.py)

🌿 **Branch:** DSA3

#### 🧠 Concept

Given an array of heights representing vertical lines, find two lines that together with the x-axis form a container that holds the maximum amount of water. The area is calculated as: `area = min(height[left], height[right]) × (right - left)`.

The two-pointer approach starts from both ends and intelligently moves inward, always shrinking from the shorter side. This greedy approach is optimal because moving the taller side can never increase the area (the height is limited by the shorter side).

#### 💡 Intuition Points

> **Physical intuition:** Imagine actual water containers. The water level is determined by the shorter wall, not the taller one. No matter how tall one wall is, water spills over the shorter wall.

> **Why greedy works:** At any point, the width is maximized. To potentially increase area, we must find taller heights. Moving the shorter pointer gives us a chance to find a taller line; moving the taller pointer guarantees we can't do better (width decreases, height can't increase).

> **Proof sketch:** If `height[left] < height[right]`, any line between left and right is constrained by `height[left]` due to shorter height. Moving left inward is the only way to potentially escape this constraint.

> **Interview insight:** This is a greedy algorithm disguised as two pointers. The greedy choice is: "always move the pointer at the shorter line."

> **Common trap:** Don't try to move both pointers at once or always move from one side. The key is to move the pointer at the minimum height.

> **When it fails:** This specific two-pointer approach only works for this exact problem structure. Don't assume all "area" problems use this technique.

#### 🔄 Visual Walkthrough

**Example:** `heights = [1, 8, 6, 2, 5, 4, 8, 3, 7]`

```
Step 1: Initialize pointers at ends
heights: [1, 8, 6, 2, 5, 4, 8, 3, 7]
          ↑                       ↑
          L                       R
Area = min(1, 7) × (8-0) = 1 × 8 = 8
maxArea = 8

Step 2: Move left (shorter side: 1 < 7)
heights: [1, 8, 6, 2, 5, 4, 8, 3, 7]
             ↑                    ↑
             L                    R
Area = min(8, 7) × (8-1) = 7 × 7 = 49
maxArea = 49 ✓

Step 3: Move right (shorter side: 7 < 8)
heights: [1, 8, 6, 2, 5, 4, 8, 3, 7]
             ↑                 ↑
             L                 R
Area = min(8, 3) × (7-1) = 3 × 6 = 18
maxArea = 49

Step 4: Move right (shorter side: 3 < 8)
heights: [1, 8, 6, 2, 5, 4, 8, 3, 7]
             ↑              ↑
             L              R
Area = min(8, 8) × (6-1) = 8 × 5 = 40
maxArea = 49

Step 5: Move either (both equal: 8 == 8), choose left
heights: [1, 8, 6, 2, 5, 4, 8, 3, 7]
                ↑           ↑
                L           R
Area = min(6, 8) × (6-2) = 6 × 4 = 24
maxArea = 49

Continue until L >= R...

Final maxArea = 49
```

**Visual representation:**

```
Heights:  1  8  6  2  5  4  8  3  7
Index:    0  1  2  3  4  5  6  7  8

Container between index 1 and 8:
|
8|   ██              ██      
7|   ██              ██      ██
6|   ██  ██          ██      ██
5|   ██  ██      ██  ██      ██
4|   ██  ██      ██  ██ ██   ██
3|   ██  ██      ██  ██ ██ ██ ██
2|   ██  ██  ██  ██  ██ ██ ██ ██
1| ██ ██  ██  ██  ██  ██ ██ ██ ██
 +----------------------------------
   0  1   2   3   4   5  6  7  8

Water fills to height 7 (min of 8 and 7)
Width = 8 - 1 = 7
Area = 7 × 7 = 49 ← Maximum
```

#### ⏱ Complexity Table

| | Value | Why |
|---|---|---|
| **Time** | O(n) | Two pointers traverse the array once, meeting in the middle; each element visited once |
| **Space** | O(1) | Only a few variables (left, right, maxArea, currentArea) used |

#### 🔗 Related Problems

- **LeetCode 11:** Container With Most Water (exact problem)
- **LeetCode 42:** Trapping Rain Water (more complex water problem)
- **LeetCode 84:** Largest Rectangle in Histogram (similar area maximization)

[⬆ Back to top](#table-of-contents)

---



### 5. Subarray Sum Finder

📁 **Files:**
- [SubarraySumFinder.java](https://github.com/ksnpavankumar/DSA-SPACE/blob/DSA3/dsa3/day-49-two-pointers/SubarraySumFinder.java)
- [SubarraySumFinder.py](https://github.com/ksnpavankumar/DSA-SPACE/blob/DSA3/dsa3/day-49-two-pointers/SubarraySumFinder.py)

🌿 **Branch:** DSA3

#### 🧠 Concept

Find a contiguous subarray that sums to a target value using the sliding window technique. This works efficiently for arrays with positive numbers because the sum is monotonically increasing as we expand the window.

#### 💡 Intuition Points

> **Sliding window mental model:** Think of a adjustable window sliding over the array. Expand it (move right pointer) when sum is too small, shrink it (move left pointer) when sum is too large.

> **Why it's O(n):** Each element is visited at most twice (once by right pointer, once by left), giving us linear time despite the nested loop appearance.

> **Critical constraint:** Only works with positive numbers. With negatives, shrinking the window might increase the sum (by removing a negative), breaking the monotonicity.

> **Interview follow-up:** "What about negative numbers?" Answer: Use prefix sum + hash map for O(n) with any numbers.

#### 🔄 Visual Walkthrough

```
Array: [1, 2, 3, 4, 5], target = 9
       i        j

Step 1: sum = 1, too small → expand
        [1, 2, 3, 4, 5]
         i     j
        sum = 1+2+3 = 6

Step 2: sum = 6, too small → expand
        [1, 2, 3, 4, 5]
         i        j
        sum = 1+2+3+4 = 10

Step 3: sum = 10, too large → shrink
        [1, 2, 3, 4, 5]
            i     j
        sum = 2+3+4 = 9 ✓

Return subarray [2, 3, 4]
```

#### ⏱ Complexity Table

| | Value | Why |
|---|---|---|
| **Time** | O(n) | Each element visited at most twice (right expands, left shrinks) |
| **Space** | O(1) | Only pointers and sum variable; result array not counted |

#### 🔗 Related Problems

- **LeetCode 209:** Minimum Size Subarray Sum
- **LeetCode 560:** Subarray Sum Equals K (allows negatives, different approach)

---

## Summary: Algorithm Comparison Table

| Category | Algorithm | Time | Space | Technique | Best For |
|----------|-----------|------|-------|-----------|----------|
| **Linked Lists** | Reverse LL | O(n) | O(1) | 3-pointer | In-place reversal |
| | Find Middle | O(n) | O(1) | Slow-fast | Middle without length |
| **Stacks** | Ball Possession | O(n) | O(n) | Stack | Forward/backward ops |
| **Two Pointers** | Container Water | O(n) | O(1) | 2-pointer | Max area problems |
| | Subarray Sum | O(n) | O(1) | Sliding window | Positive array sums |
| | Pair Difference | O(n log n) | O(1) | Sort + 2-pointer | Sorted pairs |
| | Pair Sum | O(n) | O(1) | 2-pointer | Sorted sum search |
| **Backtracking** | Parentheses | O(4^n/√n) | O(n) | Backtracking | Catalan problems |
| | Subsets | O(2^n×n) | O(n) | Backtracking | Power set |
| | Permutations | O(n×n!) | O(n) | Backtracking | All orderings |
| **Heaps** | Min Heap Build | O(n) | O(1) | Heapify | In-place heap |
| | Kth Largest | O(n log k) | O(k) | Min-heap | Top-K problems |
| | K-Sorted Array | O(n log k) | O(k) | Min-heap | Nearly sorted |
| | Merge K Lists | O(N log k) | O(k) | Min-heap | Merge streams |
| **DP** | Fibonacci | O(n) | O(n) | 1D DP | Overlapping subproblems |
| | Climbing Stairs | O(n) | O(1) | 1D DP | Count ways |
| | Min Squares | O(n√n) | O(n) | 1D DP | Optimal decomposition |
| **Knapsack** | Fractional | O(n log n) | O(n) | Greedy | Fractions allowed |
| | 0/1 Knapsack | O(nW) | O(W) | 2D DP | Whole items |
| | Unbounded | O(nW) | O(W) | 1D DP | Unlimited items |
| | Rod Cutting | O(n²) | O(n) | 1D DP | Maximize cuts |
| **Graphs** | DFS | O(V+E) | O(V) | DFS | Path exploration |
| | BFS | O(V+E) | O(V) | BFS | Shortest path |
| | Rotten Oranges | O(r×c) | O(r×c) | Multi-BFS | Spreading simulation |

---

## Technique Relationship Map

```
                    DSA Problem-Solving Techniques
                              |
        ┌─────────────────────┼─────────────────────┐
        |                     |                     |
    LINEAR DS             TREES/GRAPHS          OPTIMIZATION
        |                     |                     |
  ┌─────┴─────┐         ┌─────┴─────┐       ┌──────┴──────┐
  |           |         |           |       |             |
Arrays     Linked     DFS/BFS   Heaps      DP         Greedy
  |         Lists       |         |        |             |
  ├─ Two Ptr  ├─Slow-Fast├─Stack  ├─Min-Heap├─1D(Fib)   ├─Fractional
  ├─ Sliding  ├─Reverse  ├─Queue  ├─Max-Heap├─2D(Grid)  │ Knapsack
  ├─ Prefix   └─Cycle    └─Topo   └─Priority└─Knapsack  └─Huffman
  │   Sum         Detect    Sort      Queue      Vars
  └─ Binary
      Search

Backtracking bridges Multiple Categories:
  • Uses recursion (like Trees)
  • Explores states (like Graphs)  
  • Optimizes paths (like DP)
```

---

## When to Use What — Decision Guide

### 🔍 Problem Pattern Recognition

**Need to find pairs/subarrays?**
- **Sorted array** → Two Pointers (O(n))
- **Unsorted array** → Hash Map (O(n)) or Sort first (O(n log n))
- **Sum equals target** → Two Pointers or Prefix Sum
- **Difference equals target** → Two Pointers (sorted) or Hash Set

**Need K smallest/largest elements?**
- **K smallest** → Max-Heap of size K (O(n log k))
- **K largest** → Min-Heap of size K (O(n log k))
- **Kth element** → QuickSelect (O(n) average) or Heap (O(n log k))

**Need to merge multiple sorted sequences?**
- **2 sequences** → Two Pointers (O(n+m))
- **K sequences** → Min-Heap (O(N log k)), N = total elements

**Need optimal subset/combination?**
- **Fractions allowed** → Greedy (sort by ratio)
- **Whole items only** → Dynamic Programming (Knapsack)
- **Unlimited items** → Unbounded DP
- **Need actual items, not just value** → DP with backtracking

**Need shortest path?**
- **Unweighted graph** → BFS (O(V+E))
- **Weighted graph, positive weights** → Dijkstra (O((V+E) log V))
- **Weighted graph, negative weights** → Bellman-Ford (O(VE))
- **All pairs shortest path** → Floyd-Warshall (O(V³))

**Need to explore all possibilities?**
- **All subsets** → Backtracking (2^n)
- **All permutations** → Backtracking (n!)
- **All valid combinations (e.g., parentheses)** → Backtracking with pruning

**Need to reverse/modify linked list?**
- **Reverse entire list** → Three pointers (O(n), O(1))
- **Reverse in groups** → Recursion or iterative with groups
- **Find middle** → Slow-fast pointers (O(n), O(1))
- **Detect cycle** → Slow-fast pointers (Floyd's)

**Need count/ways to reach goal?**
- **Count paths** → DP (if optimal substructure)
- **Count combinations** → DP or Backtracking
- **Fibonacci-like** → DP with O(1) space optimization

### ⚡ Time Complexity Decision Tree

```
Input size n?
│
├─ n ≤ 20: Try O(2^n) or O(n!) → Backtracking, Brute Force
├─ n ≤ 100: Try O(n³) or O(n²log n) → DP, Advanced techniques  
├─ n ≤ 1000: Try O(n²) → Nested loops, Simple DP
├─ n ≤ 10⁶: Try O(n log n) → Sort, Heap, Divide & Conquer
└─ n ≤ 10⁹: Need O(n) or O(log n) → Two Pointers, Binary Search, Math

Special cases:
• K << n: Use K in complexity (O(n log k) for heaps)
• Need multiple queries: Preprocess with O(n) to answer in O(1) or O(log n)
```

### 🎯 Technique Selection Flowchart

```
START: What are you trying to find/optimize?
│
├─ "Maximum/Minimum" + Constraints
│   ├─ Contiguous subarray → Sliding Window or DP
│   ├─ Non-contiguous → DP or Greedy
│   └─ With limited capacity → Knapsack DP
│
├─ "Count ways to..." → DP (bottom-up building)
│
├─ "All possible..." → Backtracking (with pruning)
│
├─ "Shortest/Longest path" → BFS/DFS or DP
│
├─ "Find Kth" element → Heap or QuickSelect
│
└─ "Is it possible to..." → Greedy (if optimal substructure) or Backtracking
```

---

### 📚 Common Interview Patterns

**Pattern 1: Two Pointers**
- Problems: Pair Sum, Container Water, Remove Duplicates
- Indicator: Sorted array, opposite ends, or slow-fast

**Pattern 2: Sliding Window**
- Problems: Subarray Sum, Max Substring, Min Window
- Indicator: Contiguous elements, expand/shrink window

**Pattern 3: Top-K Elements**
- Problems: Kth Largest, Top K Frequent, K Closest Points
- Indicator: "Kth", "Top K", "Largest K"
- Solution: Heap of size K

**Pattern 4: Modified Binary Search**
- Problems: Search in Rotated Array, Find Peak Element
- Indicator: Sorted/partially sorted, O(log n) requirement

**Pattern 5: Backtracking**
- Problems: Subsets, Permutations, N-Queens, Sudoku
- Indicator: "All possible", "Generate all"

**Pattern 6: Dynamic Programming**
- Problems: Knapsack, Coin Change, Longest Increasing Subsequence
- Indicator: "Optimal", "Maximum/Minimum ways", overlapping subproblems

**Pattern 7: BFS/DFS**
- Problems: Level Order Traversal, Islands, Shortest Path
- Indicator: Trees, Graphs, connected components

---

**That's it!** You now have a comprehensive reference for all 29+ algorithms in this repository.

For quick reminders, check the [Concise Guide (v1)](DSA-VISUAL-GUIDE-v1.md).

**Happy coding! 🚀**
