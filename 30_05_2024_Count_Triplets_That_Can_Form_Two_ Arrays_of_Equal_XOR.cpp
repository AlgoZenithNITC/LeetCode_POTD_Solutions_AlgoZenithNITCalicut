class Solution {
public:
    int countTriplets(vector<int>& arr) {
        int ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            int xora = 0;
            for (int j = i + 1; j < arr.size(); j++) {
                xora ^= arr[j - 1];
                int xorb = 0;
                for (int k = j; k < arr.size(); k++) {
                    xorb ^= arr[k];
                    if (xora == xorb) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
};

