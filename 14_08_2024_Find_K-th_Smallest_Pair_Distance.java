class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0];
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(nums, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }

    private int countPairs(int[] nums, int distance) {
        int count = 0, left = 0;
        for (int right = 1; right < nums.length; ++right) {
            while (nums[right] - nums[left] > distance) {
                ++left;
            }
            count += right - left;
        }
        return count;
    }
}

