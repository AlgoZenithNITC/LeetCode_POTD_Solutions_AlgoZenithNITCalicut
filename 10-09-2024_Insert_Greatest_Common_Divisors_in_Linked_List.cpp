class Solution {
public:
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        ios_base::sync_with_stdio(0);
        cin.tie(0); cout.tie(0);
        
        if(head == NULL or head->next == NULL) return head;

        ListNode* node1 = head;
        ListNode* node2 = head->next;
        while(node2 != nullptr){
            int gcd = __gcd(node1->val, node2->val);
            ListNode* gcdn = new ListNode(gcd);

            node1->next = gcdn;
            gcdn->next = node2;

            node1 = node2;
            node2 = node2->next;
        }
        return head;
    }
};
