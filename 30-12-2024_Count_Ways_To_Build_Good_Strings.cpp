class Solution {
public:
    int countGoodStrings(int low, int high, int zero, int one) {
        vector<int>ans(high+1,0);
        ans[0]=1;
        int mod=1'000'000'007;
        for(int end=1;end<=high;++end){
            if(end>=zero){
                ans[end]+=ans[end-zero];
                ans[end]%=mod;
            }
            if(end>=one){
                ans[end]+=ans[end-one];
                ans[end]%=mod;
            }
        }
        int a=0;
        for(int i=low;i<=high;++i){
            a+=ans[i];
            a%=mod;
        }
        return a;
    }
};