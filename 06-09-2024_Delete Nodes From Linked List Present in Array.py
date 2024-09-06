class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def modifiedList(self, nums, head):
        num_set = set(nums)
        prev = None
        curr = head
        new_head = head

        while curr is not None:
            if curr.val in num_set:
                if prev is None:
                    new_head = curr.next
                else:
                    prev.next = curr.next
                curr = prev.next if prev else new_head
            else:
                prev = curr
                curr = curr.next
        
        return new_head
