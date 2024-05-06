class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev, curr = None, head

        while curr:
            curr.next, prev, curr = prev, curr, curr.next

        dummy_head = ListNode(-1)
        temp_prev, curr = dummy_head, prev
        while curr:
            if curr.val >= temp_prev.val:
                temp_prev.next = curr
                temp_prev = curr
                curr = curr.next
                temp_prev.next = None
            else:
                curr = curr.next
        
        new_prev = None
        curr = dummy_head.next
        while curr:
            curr.next, new_prev, curr = new_prev, curr, curr.next

        return new_prev
