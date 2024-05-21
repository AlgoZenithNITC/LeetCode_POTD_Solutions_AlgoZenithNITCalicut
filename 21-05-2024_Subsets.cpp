class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        if(nums.size()==0)
        return {{}};
        int n = nums.size();
        for(int m = 0 ; m< pow(2,n) -1 ; m++)
        {
            vector<int> sub;
            for(int i = 0 ; i < n ; i++)
            {
                if(m & (1<<i))
                sub.push_back(nums[i]) ;
            }
            ans.push_back(sub);
        }
        ans.push_back(nums);
        return ans;
    }
};
