class Solution {
    public int countTriplets(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int xora = 0;
            for (int j = i + 1; j < arr.length; j++) {
                xora ^= arr[j - 1];
                int xorb = 0;
                for (int k = j; k < arr.length; k++) {
                    xorb ^= arr[k];
                    if (xora == xorb) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}

