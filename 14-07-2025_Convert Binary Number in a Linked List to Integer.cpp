class Solution {
public:
    int getDecimalValue(ListNode* head) {
        string str;
        ListNode* tmp=head;
        int ans=0;
        while(tmp)
        {
            ans=ans*2+tmp->val;
            tmp=tmp->next;
        }
        return ans;

    }
};