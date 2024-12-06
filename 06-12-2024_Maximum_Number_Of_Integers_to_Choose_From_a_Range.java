class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int[] myNums = new int[n];
        Arrays.fill(myNums, 1); // Initialize myNums array with 1s

        for (int num : banned) {
            if (num > n) {
                continue;
            }
            myNums[num - 1] = 0; // Mark banned numbers
        }

        int sum = 0;
        int t = 0;

        for (int i = 0; i < n && sum + i + 1 <= maxSum; ++i) { // Adjust for 1-based indexing
            if (myNums[i] == 0) {
                continue;
            }
            sum += (i + 1); // Add 1-based index to sum
            t++;
        }
        
        return t;
    }
}
