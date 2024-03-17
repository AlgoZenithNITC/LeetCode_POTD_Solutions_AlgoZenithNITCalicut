class Solution{
  public:
    // your task is to complete this function
    int countPairs(struct Node* head1, struct Node* head2, int x) {
        // Code here
          unordered_map<int,int> mp;
        int count = 0;
        while(head1 != NULL){
            mp[x-head1->data]++;
            head1 = head1->next;
        }
        
        while(head2 != NULL){
            if(mp[head2->data] >= 1){
                count++;
            }
            head2 = head2->next;
        }
        return count;
    }
};
