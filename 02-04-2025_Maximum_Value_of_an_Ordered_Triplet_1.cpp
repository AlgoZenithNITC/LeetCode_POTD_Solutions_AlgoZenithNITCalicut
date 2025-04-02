long long maximumTripletValue(vector<int>& nums) {
    long long maxVal = LLONG_MIN;
    int numsSize = nums.size();
    
    for(int i = 0; i < numsSize - 2; ++i) {
        for(int j = i + 1; j < numsSize - 1; ++j) {
            for(int k = j + 1; k < numsSize; ++k) {
                long long tmp = (long long)(nums[i] - nums[j]) * nums[k];
                if(tmp > maxVal) {
                    maxVal = tmp;
                }
            }
        }
    }
    
    return maxVal < 0 ? 0 : maxVal;
}
