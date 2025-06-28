class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k)
    {
        int n=nums.size();
        vector<int> copy{nums.begin(),nums.end()};

        sort(copy.begin(),copy.end(),greater<int>());

        vector<int> ans;
        unordered_map<int,int> count;

        for(int i=0;i<k;++i)
        {
            count[copy[i]]++;
        }


        for(int i=0;i<n;++i)
        {
            if(count[nums[i]]>0)
            {
                ans.push_back(nums[i]);
                count[nums[i]]--;
            }
            if(ans.size()==k)
                break;
        }
        return ans;
        



    }
};