class Solution {
public:
    int minZeroArray(vector<int>& nums, vector<vector<int>>& queries) {
        int n = nums.size();
        int left = 0, right = queries.size(), answer = -1;

        auto canMakeZero = [&](int mid) {
            vector<int> diff(n + 1, 0);
            
            // Apply the first `mid` queries using the difference array
            for (int i = 0; i < mid; i++) {
                int l = queries[i][0], r = queries[i][1], val = queries[i][2];
                diff[l] -= val;
                diff[r + 1] += val;
            }

            // Apply the difference array to determine the actual decrements
            vector<int> applied(n, 0);
            int curr_decrement = 0;
            for (int i = 0; i < n; i++) {
                curr_decrement += diff[i];
                applied[i] = curr_decrement;
            }

            // Check if we can reduce all nums[i] to zero
            for (int i = 0; i < n; i++) {
                if (nums[i] + applied[i] > 0) return false;
            }
            return true;
        };

        // Binary search for the minimum `k`
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeZero(mid)) {
                answer = mid;
                right = mid - 1;  // Try to minimize `k`
            } else {
                left = mid + 1;  // Increase `k`
            }
        }

        return answer;
    }
};
