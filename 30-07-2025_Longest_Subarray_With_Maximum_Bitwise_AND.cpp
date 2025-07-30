class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int maxi=0,index=0;
        int n=nums.size();
        for(int i=0;i<n;i++){
            if(nums[i]>maxi){
                maxi=nums[i];
                index=i;
            }
        }
        int maxlen=0,len=0;

        for(int i=index;i<n;i++){
            if(nums[i]==maxi){
                len++;
                maxlen=max(len,maxlen);
            }
            else{
                len=0;
            }
        }
        return maxlen;
    }
};