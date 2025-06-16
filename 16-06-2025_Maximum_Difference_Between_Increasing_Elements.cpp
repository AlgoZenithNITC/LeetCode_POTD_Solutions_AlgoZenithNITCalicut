class Solution {
public:
int maximumDifference(vector<int>& nums)
{

    int n=nums.size();
    int smallest=nums[0];
    int ans=-1;

    for(int i=1;i<n;++i)  
    {  
        if(nums[i]<smallest)  
        {  
            smallest=nums[i];  
        }  
        
        if(ans<nums[i]-smallest)  
            ans=nums[i]-smallest;  
    }  
    if(ans<=0) return -1;  
    else return ans;  
}

};