class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        ans = 0
        tmp = head
        while tmp:
            ans = ans * 2 + tmp.val
            tmp = tmp.next
        return ans
