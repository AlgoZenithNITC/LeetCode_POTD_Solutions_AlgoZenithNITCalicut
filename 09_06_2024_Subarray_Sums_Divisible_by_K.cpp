class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        int prefixMod = 0, result = 0;
        vector<int> modGroups(k, 0);
        modGroups[0] = 1;

        for (int num : nums) {
            prefixMod = (prefixMod + num) % k;
            if (prefixMod < 0) {
                prefixMod += k;
            }
            result += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }

        return result;
    }
};

