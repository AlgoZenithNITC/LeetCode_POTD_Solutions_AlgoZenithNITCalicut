class Solution {
public:
    int specialArray(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int left = 0, right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = count_if(nums.begin(), nums.end(), [&](int num) { return num >= mid; });

            if (count == mid) {
                return mid;
            } else if (count > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
}
};
