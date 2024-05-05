// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public void deleteNode(ListNode node) {
        // :type node: ListNode
        // :rtype: void Do not return anything, modify node in-place instead.
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
