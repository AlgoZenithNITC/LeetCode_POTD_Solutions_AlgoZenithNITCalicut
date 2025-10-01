class Solution {
public:
    int numWaterBottles(int n, int x) {
        int sum=0;
        int eb=0;
        while(n)
        {
            sum+=n;
            eb+=n;
             n=eb/x;
            eb=eb%x;
        }
        return sum;
    }
};