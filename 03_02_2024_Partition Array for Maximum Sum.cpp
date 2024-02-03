//recursion
class Solution {
    private:
    int solve(vector<int>&num,int ind,int k,int n)
    {

    // Base case: If the current index is equal to the size of the array, return 0.
    if (ind == n) return 0;

    int len = 0;
    int maxi = INT_MIN;
    int maxAns = INT_MIN;

    // Loop through the array starting from the current index.
    for (int j = ind; j < min(ind + k, n); j++) {
        len++;
        maxi = max(maxi, num[j]);
        int sum = len * maxi + solve(num,j + 1, k,n);
        maxAns = max(maxAns, sum);
    }
    return maxAns;
    }
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n=arr.size();
        int ind=0;
        int ans=solve(arr,ind,k,n);
        return ans;
    }
};

//*******************************************************************************************************************************************************************************************************************
//Memoization
class Solution {
    private:
    int solve(vector<int>&num,int ind,int k,int n,vector<int>&dp)
    {

    // Base case: If the current index is equal to the size of the array, return 0.
    if (ind == n) return 0;

    if (dp[ind] != -1) return dp[ind];
    int len = 0;
    int maxi = INT_MIN;
    int maxAns = INT_MIN;

    // Loop through the array starting from the current index.
    for (int j = ind; j < min(ind + k, n); j++) {
        len++;
        maxi = max(maxi, num[j]);
        int sum = len * maxi + solve(num,j + 1, k,n,dp);
        maxAns = max(maxAns, sum);
    }
    return dp[ind]=maxAns;
    }
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n=arr.size();
        int ind=0;
        vector<int>dp(n, -1);
        int ans=solve(arr,ind,k,n,dp);
        return ans;
    }
};

//******************************************************************************************************************************************************************************************************************
//Tabulation

class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
    int n=arr.size();
    
    // Create a DP array to store the maximum sum.
    vector<int> dp(n + 1, 0);
    
    // Iterate through the array from right to left.
    for (int ind = n - 1; ind >= 0; ind--) {
        int len = 0;
        int maxi = INT_MIN;
        int maxAns = INT_MIN;
        
        // Loop through the next k elements (or remaining elements if k is smaller).
        for (int j = ind; j < min(ind + k, n); j++) {
            len++;
            maxi = max(maxi, arr[j]);
            int sum = len * maxi + dp[j + 1];
            maxAns = max(maxAns, sum);
        }
        
        // Store the computed maximum sum in the DP array.
        dp[ind] = maxAns;
    }
    
    // The maximum sum after partitioning the entire array is stored in dp[0].
    return dp[0];
    }
};
