class Solution {
public:
    int maxAdjacentDistance(vector<int>& nums) {
        int maxdiff=abs(nums[nums.size()-1]-nums[0]);

        if (nums.size() < 2) return 0; 
        for(int i=0;i<nums.size()-1;i++)
        {
            if(maxdiff<abs(nums[i]-nums[i+1]))
            {
                maxdiff=abs(nums[i]-nums[i+1]);
            }
        }
        return maxdiff;
    }
};