class Solution {
public:
    long long maximumHappinessSum(vector<int>& happiness, int k) {
         sort(happiness.begin(),happiness.end(),greater<int>());
        long long maxSum=0;
        for(int i=0;i<k;i++){
            happiness[i]-=i;
            if(happiness[i]>0)
              maxSum+=happiness[i];
            else
              break;  
        }
        return maxSum;
    }
};
