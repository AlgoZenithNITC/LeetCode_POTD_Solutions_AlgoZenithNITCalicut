class Solution{
    public int minOperations(int[] nums) {
        int n = nums.length, ans = n;
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        List<Integer> unique_elements = new ArrayList<>(s);
        Collections.sort(unique_elements);
        int size = unique_elements.size();
        for (int start = 0; start < size; start++) {
            int end_index = upperBound(unique_elements, start, size, unique_elements.get(start) + n - 1);
            ans = Math.min(ans, n - (end_index - start));
        }
        return ans;
    }
    private static int upperBound(List<Integer> list, int low, int high, int element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (element >= list.get(middle)) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }
}
