# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class ReverseLinkedList:
    """
    This class provides a method to reverse a singly linked list in-place and in one pass.
    """

    # @param A : head node of the linked list
    # @return the head node of the reversed linked list
    def reverseList(self, A):
        # If the list has only one node, no reversal is needed
        if A is None or A.next is None:
            return A

        prev = None  # Tracks the previous node
        current = A  # Starts at the head of the list
        
        # Traverse the list and reverse links one node at a time
        while current:
            temp = current.next  # Store the next node
            current.next = prev  # Reverse the current node's pointer
            prev = current       # Move prev to the current node
            current = temp        # Move current to the next node
        
        # Return the new head of the reversed list
        return prev

    """
    Example Intuition:
    ------------------
    Consider a list: 1 -> 2 -> 3 -> None
    Step-by-step process of reversing the list:

    Initial state:
    prev = None, current = 1 -> 2 -> 3 -> None

    Step 1:
    temp = 2 -> 3 -> None  (store next node)
    current.next = None    (reverse current's pointer to prev)
    prev = 1 -> None       (move prev forward)
    current = 2 -> 3 -> None (move current forward)

    Step 2:
    temp = 3 -> None
    current.next = 1 -> None
    prev = 2 -> 1 -> None
    current = 3 -> None

    Step 3:
    temp = None
    current.next = 2 -> 1 -> None
    prev = 3 -> 2 -> 1 -> None
    current = None (end of list)

    Final reversed list: 3 -> 2 -> 1 -> None

    This approach ensures an in-place reversal in one traversal.
    """

# Example usage and explanation
def print_list(head):
    """Utility function to print the linked list."""
    result = []
    while head:
        result.append(str(head.val))
        head = head.next
    return " -> ".join(result) + " -> None"

# Example 1: Original list 1 -> 2 -> 3 -> None
head1 = ListNode(1)
head1.next = ListNode(2)
head1.next.next = ListNode(3)

reverse_linked_list = ReverseLinkedList()

print("Original List: ", print_list(head1))
reversed_head1 = reverse_linked_list.reverseList(head1)
print("Reversed List: ", print_list(reversed_head1))

# Example 2: Single node list 1 -> None
head2 = ListNode(1)
print("\nOriginal List: ", print_list(head2))
reversed_head2 = reverse_linked_list.reverseList(head2)
print("Reversed List: ", print_list(reversed_head2))

# Example 3: Empty list
head3 = None
print("\nOriginal List: None")
reversed_head3 = reverse_linked_list.reverseList(head3)
print("Reversed List: None")

# Example 4: Longer list 10 -> 20 -> 30 -> 40 -> None
head4 = ListNode(10)
head4.next = ListNode(20)
head4.next.next = ListNode(30)
head4.next.next.next = ListNode(40)

print("\nOriginal List: ", print_list(head4))
reversed_head4 = reverse_linked_list.reverseList(head4)
print("Reversed List: ", print_list(reversed_head4))
