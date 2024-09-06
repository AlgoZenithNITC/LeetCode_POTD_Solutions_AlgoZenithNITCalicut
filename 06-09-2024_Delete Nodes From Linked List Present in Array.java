import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode modifiedList(List<Integer> nums, ListNode head) {
        Set<Integer> set = new HashSet<>(nums);
        ListNode prev = null;
        ListNode curr = head;
        ListNode newHead = head;

        while (curr != null) {
            if (set.contains(curr.val)) {
                if (prev == null) {
                    newHead = curr.next;
                } else {
                    prev.next = curr.next;
                }
                // No direct memory management like delete in Java
                curr = (prev != null) ? prev.next : newHead;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return newHead;
    }
}
