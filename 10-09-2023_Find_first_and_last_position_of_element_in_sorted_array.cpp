class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target){
        auto it = lower_bound(nums.begin(), nums.end(), target);
        if(it == nums.end() or *it != target){
            return {-1, -1};
        }
        auto it_temp = upper_bound(nums.begin(), nums.end(), target);
        it_temp--;
        int low = it - nums.begin(), high = it_temp - nums.begin();
        return {low, high}; 
    }
};
