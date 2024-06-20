class Solution {
    public boolean canPlaceBalls(int[] position, int m, int force) {
        int count = 1;
        int lastPosition = position[0];

        for (int i = 1; i < position.length; ++i) {
            if (position[i] - lastPosition >= force) {
                ++count;
                lastPosition = position[i];
                if (count == m) {
                    return true;
                }
            }
        }
        return false;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlaceBalls(position, m, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
