class Solution {
    public long minEnd(long n, long x) {
        long finalValue = x;
        long remaining = n - 1;
        long bitPos = 1;

        while (remaining != 0) {
            if ((x & bitPos) == 0) {
                finalValue |= (remaining & 1) * bitPos;
                remaining >>= 1;
            }
            bitPos <<= 1;
        }

        return finalValue;
    }
}
