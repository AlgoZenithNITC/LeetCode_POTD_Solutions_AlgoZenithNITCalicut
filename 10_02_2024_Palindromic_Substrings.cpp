#include <string>

class Solution {
public:
    int countSubstrings(std::string s) {
        
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s[l] == s[r]) {
                result++;
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s[l] == s[r]) {
                result++;
                l--;
                r++;
            }
        }
        return result;
    }
};

