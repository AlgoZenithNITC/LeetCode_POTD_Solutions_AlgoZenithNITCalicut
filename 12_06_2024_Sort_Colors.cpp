class Solution {
public:
    void sortColors(vector<int>& nums) {
        unordered_map<int, int> mp;
        for (int i : nums) {
            mp[i]++;
        }
        
        int idx = 0;
        for (int key = 0; key < 3; key++) {  // We know the keys are 0, 1, 2
            int count = mp.count(key) ? mp[key] : 0;  // Use count to handle missing keys
            for (int _ = 0; _ < count; _++) {
                nums[idx++] = key;
            }
        }
    }
};

