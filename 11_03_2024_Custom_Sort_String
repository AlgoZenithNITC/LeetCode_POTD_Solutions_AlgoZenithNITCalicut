class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char, int>Count;
        for (char c : order) {
            Count[c] = 0;
        }
        
        for (char c : s) {
            if (Count.find(c) != Count.end()) {
                Count[c]++;
            }
        }
        
        string ans;
        for (char c : order) {
            ans.append(Count[c], c);
        }
        
        for (char c : s) {
            if (Count.find(c)==Count.end()) {
                ans.push_back(c);
            }
        }
        
        return ans;
    }
};
