
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);

        // Sort in descending order
        Arrays.sort(copy);
        reverse(copy); // Since Arrays.sort is ascending by default

        // Count the top k values
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < k; ++i) {
            count.put(copy[i], count.getOrDefault(copy[i], 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n && ans.size() < k; ++i) {
            if (count.getOrDefault(nums[i], 0) > 0) {
                ans.add(nums[i]);
                count.put(nums[i], count.get(nums[i]) - 1);
            }
        }

        // Convert to array
        int[] result = new int[k];
        for (int i = 0; i < k; ++i)
            result[i] = ans.get(i);

        return result;
    }

    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
