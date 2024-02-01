class Solution {
public:
    vector<vector<int>> divideArray(vector<int>& nums, int k) {
        vector<vector<int>> ans;
        int i;
        sort(nums.begin(),nums.end());
        for(i=0;i<nums.size();i=i+3)
        {
            if(nums[i+2]-nums[i]>k)
            return {};
            ans.push_back({nums[i],nums[i+1],nums[i+2]});
        }
        return ans;    
    }
};
