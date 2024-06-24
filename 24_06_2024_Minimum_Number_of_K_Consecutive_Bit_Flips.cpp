class Solution {
public:
    int minKBitFlips(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> flipped(n, 0);
        int times = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                times -= flipped[i - k];
            }
            if (((nums[i] == 1 && times % 2 == 1) || (nums[i] == 0 && times % 2 == 0))) {
                if (i + k > n) {
                    return -1;
                }
                ans++;
                times++;
                flipped[i] = 1;
            }
        }
        return ans;
    }
};

