class Solution
{
public:
    
    void flip(int i,vector<int> &nums)
    {
        for(int j=i;j<i+3;j++)
        {
            nums[j]=(nums[j]==1)?0:1;
        }
    }
    int minOperations(vector<int>& nums) 
    {
        int zero=0;
        int flips=0;
        int n=nums.size();
        for(auto i:nums)
        {
            if(i==0)
            {
                zero++;
            }
        }
        if(zero==0)
        {
            return 0;
        }
        for(int i=0;i<n-2;i++)
        {
            if(nums[i]==0)
            {
                flip(i,nums);
                flips++;
            }
        }

        zero=0;
        for(auto i:nums)
        {
            if(i==0)
            {
                zero++;
            }
        }
        if(zero==0)
        {
            return flips;
        }

        return -1;


        
    }
};