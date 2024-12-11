/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class LinkedListMiddle {
    /**
     * Question: 
     * Given the head of a singly linked list, return the value of the middle node. 
     * If the list has an even number of nodes, return the value of the second middle node.
     */

    public int findMiddle(ListNode head) {
        if (head == null) {
            return -1; // Handle edge case of an empty list
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Move slow by 1 step and fast by 2 steps to find the middle node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.val; // Slow will point to the middle node
    }

    /**
     * Intuition:
     * - Use the "slow and fast pointer" technique to find the middle node in one traversal.
     * - The slow pointer moves one step at a time, while the fast pointer moves two steps.
     * - When the fast pointer reaches the end, the slow pointer will be at the middle.
     * 
     * Examples:
     * 1. Odd-length list:
     *    Input: 1 -> 2 -> 3 -> 4 -> 5
     *    Execution:
     *    slow = 1, fast = 1
     *    slow = 2, fast = 3
     *    slow = 3, fast = 5
     *    Output: 3
     * 
     * 2. Even-length list:
     *    Input: 1 -> 2 -> 3 -> 4
     *    Execution:
     *    slow = 1, fast = 1
     *    slow = 2, fast = 3
     *    slow = 3, fast = null
     *    Output: 3
     * 
     * 3. Single-node list:
     *    Input: 1
     *    Output: 1
     * 
     * 4. Empty list:
     *    Input: null
     *    Output: -1
     * 
     * Time Complexity:
     * - Each node is visited once, so the time complexity is O(n), where n is the number of nodes in the list.
     * 
     * Space Complexity:
     * - The algorithm uses two pointers and no extra space, so the space complexity is O(1).
     */
}

// Utility class to test the LinkedListMiddle class
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

class TestLinkedListMiddle {
    public static void main(String[] args) {
        LinkedListMiddle solution = new LinkedListMiddle();
        
        // Utility method to build linked list
        ListNode buildLinkedList(int[] values) {
            if (values.length == 0) return null;
            ListNode head = new ListNode(values[0]);
            ListNode current = head;
            for (int i = 1; i < values.length; i++) {
                current.next = new ListNode(values[i]);
                current = current.next;
            }
            return head;
        }
        
        // Test cases
        int[][] inputs = {
            {1, 2, 3, 4, 5},  // Odd-length list
            {1, 2, 3, 4},      // Even-length list
            {1},               // Single node
            {}                 // Empty list
        };
        
        for (int i = 0; i < inputs.length; i++) {
            ListNode head = buildLinkedList(inputs[i]);
            int result = solution.findMiddle(head);
            System.out.println("Test Case " + (i + 1) + ": Middle Value = " + result);
        }
    }
}
