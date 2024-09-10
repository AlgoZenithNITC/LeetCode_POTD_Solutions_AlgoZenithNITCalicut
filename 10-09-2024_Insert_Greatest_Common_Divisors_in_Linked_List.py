class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        node1 = head
        while node1.next:
            node2 = node1.next
            gcdv = gcd(node1.val, node2.val)
            gcdn = ListNode(gcdv)
            node1.next = gcdn
            gcdn.next = node2
            node1 = node2
        
        return head
