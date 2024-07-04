class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        current = head.next  # Skip the initial zero node
        new_head = current  # This will be the new head of the merged list
        prev = None
        sum = 0

        while current:
            if current.val == 0:  # When encountering a zero
                current.val = sum  # Set the current node's value to the sum
                if prev:
                    prev.next = current  # Connect the previous non-zero node to the current node
                else:
                    new_head = current
                prev = current  # Update the previous node
                sum = 0  # Reset the sum
            else:
                sum += current.val  # Add the current node's value to the sum
            current = current.next  # Move to the next node

        return new_head  # Return the new head of the modified list
