class Solution {
public:
    int CountAtMost(vector<int>& nums,int k){
        int count=0;
        int j=0;
        unordered_map<int,int>mp;
        for(int i=0;i<nums.size();i++){
                mp[nums[i]]++;
                while(j<=i&&mp.size()>k){
                      if(--mp[nums[j]]==0)mp.erase(nums[j]);
                      j++;
                }
                count+=(i-j+1);
        }
        return count;
    }
    int subarraysWithKDistinct(vector<int>& nums, int k) {
          int k1=CountAtMost(nums,k);
          int k2=CountAtMost(nums,k-1);
          return k1-k2;
    }
};
