class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        int l=nums.size();
        vector<int> v(l);
        int k=0;
        for(int i=0;i<l;i++){
            if(nums[i]>0){
                v[k]=nums[i];
                k+=2;
            }
        }
        k=1;
        for(int i=0;i<l;i++){
            if(nums[i]<0){
                v[k]=nums[i];
                k+=2;
            }
        }
        return v;
       
    }
};
