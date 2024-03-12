import java.util.HashMap;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        HashMap<Integer, ListNode> prefixSumToNode = new HashMap<>();
        int prefixSum = 0;
        for (ListNode current = dummy; current != null; current = current.next) {
            prefixSum += current.val;
            if (prefixSumToNode.containsKey(prefixSum)) {
                ListNode prev = prefixSumToNode.get(prefixSum);
                ListNode toRemove = prev.next;
                int p = prefixSum + (toRemove != null ? toRemove.val : 0);
                while (p != prefixSum) {
                    prefixSumToNode.remove(p);
                    toRemove = toRemove.next;
                    p += (toRemove != null ? toRemove.val : 0);
                }
                prev.next = current.next;
            } else {
                prefixSumToNode.put(prefixSum, current);
            }
        }
        return dummy.next;
    }
}

