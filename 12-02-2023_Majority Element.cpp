class Solution {
public:
    int majorityElement(vector<int>& nums) {
        //moore voting algorithm
        int ele=nums[0];
        int count=1;
        int n=nums.size();
        for(int i=1;i<n;i++)
        {
            if(count==0)
            {
                ele=nums[i];
                count++;
            }
            else if(ele==nums[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        return ele;
    }
};
