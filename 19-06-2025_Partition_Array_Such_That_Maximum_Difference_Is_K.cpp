class Solution {
public:
    int partitionArray(vector<int>& nums, int k) 
    {
        sort(nums.begin(),nums.end());

        int i=0;
        int j=0;
         
        int res=0;
        while(j<nums.size())
        {
             if((nums[j]-nums[i])<=k)
             {
                 j++;
             }

             else
             {
                 res+=1;
                 i=j;
             }
        }   


        return res+1; //count the end window that will also be a valid subsequence
    }
};
