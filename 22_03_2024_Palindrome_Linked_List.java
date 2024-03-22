/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> test = new ArrayList<>();
        while (head != null) {
            test.add(head.val);
            head = head.next;
        }
        int n = test.size();
        for (int i = 0; i < n / 2; i++) {
            if (test.get(i) != test.get(n - 1 - i))
                return false;
        }
        return true;
    }
}

