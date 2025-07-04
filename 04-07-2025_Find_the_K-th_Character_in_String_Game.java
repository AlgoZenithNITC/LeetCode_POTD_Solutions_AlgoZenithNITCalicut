class Solution {
    public char kthCharacter(long k, int[] operations) {
        long length = 1; // Initial length of the string
        int n = 0;       // Number of operations needed to reach length ≥ k

        // Step 1: Compute how many operations we need until the string is at least length k
        while (k > length) {
            length *= 2;
            n++;
        }

        int shiftCount = 0;

        // Step 2: Work backwards through the operations
        while (n > 0 && k > 1) {
            if (k > length / 2) {
                k -= length / 2;
                if (operations[n - 1] == 1) {
                    shiftCount++;
                }
            }
            length /= 2;
            n--;
        }

        return (char) ('a' + (shiftCount % 26));
    }
}
