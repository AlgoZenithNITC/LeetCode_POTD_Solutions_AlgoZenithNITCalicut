class Solution {
public:
    int maxIncreasingSubarrays(vector<int>& nums) {
        int n = nums.size();
        int cnt = 1, prev = 0;
        int max = 0;
        for(int i=1; i<n; ++i)
        {
            if(nums[i]>nums[i-1])
            {
                cnt++;
            }
            else
            {
                prev = cnt;
                cnt = 1;
            }
            int temp = prev;
            if(cnt<prev)
            {
                temp = cnt;
            }
            if(temp>max)
            {
                max = temp;
            }
            if(cnt/2>max)
            {
                max = cnt/2;
            }
        }
        return max;
    }
};
