# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class LinkedListMiddle:
    """
    Question: 
    Given the head of a singly linked list, return the value of the middle node. 
    If the list has an even number of nodes, return the value of the second middle node.
    """

    # @param head : head node of linked list
    # @return an integer
    def findMiddle(self, head):
        # If there are fewer than two nodes, return the head's value
        if head is None or head.next is None:
            return head.val
        
        # Use the slow and fast pointer approach to find the middle
        slow = head
        fast = head
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        # Return the value of the middle node
        return slow.val

    """
    Intuition:
    - The "slow and fast pointer" technique is used to find the middle node in one traversal.
    - The slow pointer moves one step at a time, while the fast pointer moves two steps.
    - When the fast pointer reaches the end, the slow pointer will be at the middle.

    Examples:
    1. Odd-length list:
       Input: 1 -> 2 -> 3 -> 4 -> 5
       Execution:
       slow = 1, fast = 1
       slow = 2, fast = 3
       slow = 3, fast = 5
       Output: 3

    2. Even-length list:
       Input: 1 -> 2 -> 3 -> 4
       Execution:
       slow = 1, fast = 1
       slow = 2, fast = 3
       slow = 3, fast = None
       Output: 3

    3. Single-node list:
       Input: 1
       Output: 1

    4. Two-node list:
       Input: 1 -> 2
       Output: 2

    Time Complexity:
    - Each node is visited once, so the time complexity is O(n), where n is the number of nodes in the list.

    Space Complexity:
    - The algorithm uses two pointers and no extra space, so the space complexity is O(1).
    """

# Utility function to build a linked list from a list of values
def build_linked_list(values):
    if not values:
        return None
    head = ListNode(values[0])
    current = head
    for val in values[1:]:
        current.next = ListNode(val)
        current = current.next
    return head

# Test Cases
if __name__ == "__main__":
    linked_list = LinkedListMiddle()
    inputs = [
        [1, 2, 3, 4, 5],  # Odd-length list
        [1, 2, 3, 4],      # Even-length list
        [1],               # Single node
        [1, 2]             # Two nodes
    ]

    for i, input_list in enumerate(inputs, start=1):
        head = build_linked_list(input_list)
        result = linked_list.findMiddle(head)
        print(f"Test Case {i}: Input = {input_list} -> Middle Value = {result}")
