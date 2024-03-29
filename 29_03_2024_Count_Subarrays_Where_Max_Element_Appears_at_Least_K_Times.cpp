#include <vector>
using namespace std;

class Solution {
public:
    int countSubarrays(vector<int>& nums, int k) {
        int max_element = *max_element(nums.begin(), nums.end());
        int ans = 0;
        int start = 0;
        int max_elements_in_window = 0;
        for (int end = 0; end < nums.size(); end++) {
            if (nums[end] == max_element) {
                max_elements_in_window++;
            }
            while (max_elements_in_window == k) {
                if (nums[start] == max_element) {
                    max_elements_in_window--;
                }
                start++;
            }
            ans += start;
        }
        return ans;
    }
};

