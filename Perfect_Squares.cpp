class Solution {
public:
    int numSquares(int n) {
        int *kow = new int[n + 1];
        kow[0] = 0;
        kow[1] = 1;
        for(int i = 2; i <= n; i++){
            kow[i] = INT_MAX;
            for(int j = 1; j*j <= i; j++){
                kow[i] = min(kow[i], 1 + kow[i - j*j]);
            }
        }
        return kow[n];
    }
};
