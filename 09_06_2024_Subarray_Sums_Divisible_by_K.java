import java.util.Arrays;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixMod = 0;
        int result = 0;
        int[] modGroups = new int[k];
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
}

