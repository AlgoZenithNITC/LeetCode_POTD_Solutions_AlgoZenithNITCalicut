class Solution {
public:
    ListNode* modifiedList(vector<int>& nums, ListNode* head) 
    {
        unordered_map<int,int> mp;
        for(int i=0;i<nums.size();i++)
            mp[nums[i]]=1;
        ListNode* prev=NULL;
        ListNode* curr=head;
        ListNode* newhead=head;
        while(curr!=NULL)
        {
            if(mp.find(curr->val)!=mp.end())
            {
                if(prev==NULL)
                  newhead=curr->next;
                else
                  prev->next=curr->next;
                delete(curr);
                if(prev)
                curr=prev->next;
                else 
                curr=newhead;
            }
            else{
                prev=curr;
                curr=curr->next;
            }
        }
        return newhead;
    }
};
