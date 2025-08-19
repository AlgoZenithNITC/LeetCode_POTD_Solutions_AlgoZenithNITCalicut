class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        long long count = 0;
        long long zeroLength = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroLength++;
                count += zeroLength;
            } else {
                zeroLength = 0;
            }
        }

        return count;
    }
};
