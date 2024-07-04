class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode current = head.next; // Skip the initial zero node
        ListNode newHead = current; // This will be the new head of the merged list
        ListNode prev = null;
        int sum = 0;

        while (current != null) {
            if (current.val == 0) { // When encountering a zero
                current.val = sum; // Set the current node's value to the sum
                if (prev != null) {
                    prev.next = current; // Connect the previous non-zero node to the current node
                } else {
                    newHead = current;
                }
                prev = current; // Update the previous node
                sum = 0; // Reset the sum
            } else {
                sum += current.val; // Add the current node's value to the sum
            }
            current = current.next; // Move to the next node
        }

        return newHead; // Return the new head of the modified list
    }
}
