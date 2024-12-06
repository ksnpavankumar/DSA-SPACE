/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ReverseLinkedList {

    /**
     * Reverses a singly linked list in-place and in one pass.
     * @param head The head node of the singly linked list.
     * @return The head node of the reversed linked list.
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, current = null;
        if (head == null || head.next == null) {
            return head; // If the list is empty or has one node, no need to reverse.
        }
        current = head;
        while (head != null) {
            ListNode t = head.next; // Store the next node.
            head.next = prev;       // Reverse the current node's pointer.
            prev = head;            // Move prev forward to the current node.
            head = t;               // Move head forward to the next node.
        }
        return prev; // Return the new head of the reversed list.
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        // Test case 1: 1 -> 2 -> 3 -> null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        System.out.println("Original List: " + printList(head1));
        ListNode reversed1 = solution.reverseList(head1);
        System.out.println("Reversed List: " + printList(reversed1));

        // Test case 2: Empty list (null)
        ListNode head2 = null;
        System.out.println("Original List: " + printList(head2));
        ListNode reversed2 = solution.reverseList(head2);
        System.out.println("Reversed List: " + printList(reversed2));

        // Test case 3: Single node (1 -> null)
        ListNode head3 = new ListNode(1);
        System.out.println("Original List: " + printList(head3));
        ListNode reversed3 = solution.reverseList(head3);
        System.out.println("Reversed List: " + printList(reversed3));

        // Test case 4: 5 -> 10 -> 15 -> 20 -> null
        ListNode head4 = new ListNode(5);
        head4.next = new ListNode(10);
        head4.next.next = new ListNode(15);
        head4.next.next.next = new ListNode(20);
        System.out.println("Original List: " + printList(head4));
        ListNode reversed4 = solution.reverseList(head4);
        System.out.println("Reversed List: " + printList(reversed4));
    }

    /**
     * Utility method to print a linked list.
     * @param head The head node of the linked list.
     * @return A string representation of the linked list.
     */
    public static String printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" -> ");
            head = head.next;
        }
        sb.append("null");
        return sb.toString();
    }
}

/**
 * Definition for the ListNode class.
 */
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { 
        val = x; 
        next = null; 
    }
}

/**
 * Example Explanation:
 *
 * Let's take an example linked list: 1 -> 2 -> 3 -> 4 -> null
 *
 * Step-by-step reversal process:
 *
 * 1. Initial State:
 *    prev = null, current = A (head pointing to 1), A = 1
 *    List: 1 -> 2 -> 3 -> 4 -> null
 *
 * 2. First Iteration:
 *    t = A.next (2), A.next = prev (null)
 *    prev = A (1), A = t (2)
 *    List: 1 -> null, 2 -> 3 -> 4 -> null
 *
 * 3. Second Iteration:
 *    t = A.next (3), A.next = prev (1)
 *    prev = A (2), A = t (3)
 *    List: 2 -> 1 -> null, 3 -> 4 -> null
 *
 * 4. Third Iteration:
 *    t = A.next (4), A.next = prev (2)
 *    prev = A (3), A = t (4)
 *    List: 3 -> 2 -> 1 -> null, 4 -> null
 *
 * 5. Fourth Iteration:
 *    t = A.next (null), A.next = prev (3)
 *    prev = A (4), A = t (null)
 *    List: 4 -> 3 -> 2 -> 1 -> null
 *
 * 6. End of Loop:
 *    A becomes null, prev points to the new head of the reversed list (4).
 *
 * Final Reversed List: 4 -> 3 -> 2 -> 1 -> null
 *
 * This ensures the linked list is reversed in-place in O(n) time and O(1) space.
 */
