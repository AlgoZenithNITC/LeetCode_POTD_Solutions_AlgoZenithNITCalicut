class Solution {
public:
    bool doesValidArrayExist(vector<int>& derived) {
        int n = derived.size();
        
        // Initialize two possible starting values for the original array
        int start0 = 0; // Assume original[0] = 0
        int start1 = 1; // Assume original[0] = 1

        // Calculate the original array based on start0
        vector<int> original0(n);
        original0[0] = start0;
        for (int i = 1; i < n; ++i) {
            original0[i] = original0[i - 1] ^ derived[i - 1];
        }
        // Check if the last condition holds for start0
        if ((original0[n - 1] ^ original0[0]) == derived[n - 1]) {
            return true;
        }

        // Calculate the original array based on start1
        vector<int> original1(n);
        original1[0] = start1;
        for (int i = 1; i < n; ++i) {
            original1[i] = original1[i - 1] ^ derived[i - 1];
        }
        // Check if the last condition holds for start1
        if ((original1[n - 1] ^ original1[0]) == derived[n - 1]) {
            return true;
        }

        return false; // No valid original array found
    }
};
