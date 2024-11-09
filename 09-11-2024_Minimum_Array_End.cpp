class Solution {
public:
    long long minEnd(int n, int x) {
        long long final_value = x;
        long long remaining = n - 1;
        long long bit_pos = 1;

        while (remaining) {
            if (!(x & bit_pos)) {
                final_value |= (remaining & 1) * bit_pos;
                remaining >>= 1;
            }
            bit_pos <<= 1;
        }

        return final_value;
    }
};
