class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        ListNode tmp = head;
        while (tmp != null) {
            ans = ans * 2 + tmp.val;
            tmp = tmp.next;
        }
        return ans;
    }
}