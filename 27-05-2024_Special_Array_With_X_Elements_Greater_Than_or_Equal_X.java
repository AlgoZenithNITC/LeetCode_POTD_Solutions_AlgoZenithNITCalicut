class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num >= mid) {
                    count++;
                }
            }

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
}
