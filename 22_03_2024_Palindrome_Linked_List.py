# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        test = []
        while head is not None:
            test.append(head.val)
            head = head.next
        n = len(test)
        for i in range(n // 2):
            if test[i] != test[n - 1 - i]:
                return False
        return True
