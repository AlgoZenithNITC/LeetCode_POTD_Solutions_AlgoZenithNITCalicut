class Solution {
public:
    long long maximumValueSum(vector<int>& nums, int k, vector<vector<int>>& edges) {
        long long sum =0 , cnt =0 , temp=INT_MAX;

        for(int it : nums){
            int a = it^k;
            long long b = a-it;
            if(a>it){
                sum+=a; 
                temp = min(temp ,b);
                cnt++;
            }else{
                sum+=it;
                temp=min(temp,-b);
            }
        }

        if(cnt%2==0) return sum;

        return sum-temp;
    }
};
