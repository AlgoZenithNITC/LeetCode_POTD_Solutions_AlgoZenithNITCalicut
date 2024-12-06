class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        vector<int> myNums(n, 1);
        for(int i=0; i<banned.size(); ++i)
        {
            if(banned[i]>n)
            {
                continue;
            }
            myNums[banned[i]-1] = 0;
        }
        int sum = 0;
        int t = 0;
        for(int i=0; i<n && sum + i <= maxSum; ++i)
        {
            if(myNums[i]==0)
            {
                continue;
            }
            sum++;
            sum += i;
            t++;
        }
        return t;
    }
};