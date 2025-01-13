class Solution {
public:
    int minimumLength(string s) {
        unordered_map<char, int> mp;
        for (char c : s)
            mp[c]++;
        int minLen = 0;
        for (auto it : mp)
            minLen += it.second % 2 == 0 ? 2 : 1;
        return minLen;
    }
};
