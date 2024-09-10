class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) return head;

        ListNode node1 = head;
        ListNode node2 = head.next;

        while(node2 != null){
            int gcdv = gcd(node1.val, node2.val);
            ListNode gcdn = new ListNode(gcdv);

            node1.next = gcdn;
            gcdn.next = node2;
            node1 = node2;
            node2 = node2.next;
        }
        return head;
    }

    private int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
