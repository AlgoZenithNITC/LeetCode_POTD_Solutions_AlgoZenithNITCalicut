class Solution {
public:
    string minWindow(string s, string t) {
       if (t == "") return "";
        unordered_map<char, int> mpt;
        for (auto& x : t) mpt[x]++;
        int len = s.size();
        pair<int, int> pr = {-1, -1};
        unordered_map<char, int> mps;
        int have = 0, need = mpt.size(), j = 0;
        for (int i = 0; i < s.size(); i++) {
            mps[s[i]]++;
            if (mpt.count(s[i]) && mps[s[i]] == mpt[s[i]]) {
                have++;
            }
            while (have == need) {
                if (i - j + 1 <= len) {
                    pr.first = j, pr.second = i;
                    len = i - j + 1;
                }
                mps[s[j]]--;
                if (mpt.count(s[j]) && mps[s[j]] < mpt[s[j]]) {
                    have--;
                }
                j++;
            }
        }
        if (pr.second == -1 || pr.first == -1) return "";
        string ans = "";
        for (int i = pr.first; i <= pr.second; i++) {
            ans.push_back(s[i]);
        }
        return ans;
    }
};
