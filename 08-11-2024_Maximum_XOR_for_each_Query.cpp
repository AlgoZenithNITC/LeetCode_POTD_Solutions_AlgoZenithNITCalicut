#include <vector>

std::vector<int> getMaximumXor(std::vector<int>& nums, int maximumBit) {
    int numsSize = nums.size();
    std::vector<int> answer(numsSize);
    std::vector<int> xorPrefix(numsSize);
    
    xorPrefix[0] = nums[0];
    for(int i = 1; i < numsSize; ++i) {
        xorPrefix[i] = xorPrefix[i - 1] ^ nums[i];
    }
    
    for(int i = 0; i < numsSize; ++i) {
        int maxNum = (1 << maximumBit) - 1; // Max number with maximumBit bits all set to 1
        answer[i] = xorPrefix[numsSize - i - 1] ^ maxNum;
    }
    
    return answer;
}
