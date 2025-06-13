class Solution {
public:
    int minimizeMax(vector<int>& nums, int p) {
        if(p==0)return 0;
        int n=nums.size();
        sort(nums.begin(),nums.end());
        int left=0,right=nums[n-1]-nums[0];
        while(left<right){
            int mid= (left+right)/2, pairs=0;
            for(int i=1;i<n;++i){
                if(mid>=nums[i]-nums[i-1]){
                    pairs++;
                    i++;
                }
            }
            if(pairs>=p)right=mid;
            else left=mid+1;
        }
        return left;
    }
};