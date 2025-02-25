class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        long long oddcount = 0, prefixsum = 0;
        int arrSize = arr.size();
        
        for (int num : arr) {
            prefixsum += num;
            oddcount += prefixsum % 2;
        }
        
        oddcount = oddcount + (arrSize - oddcount) * oddcount;
        return oddcount % 1000000007;

    }
};
