class Solution {
public:
    int maxUniqueSplit(std::string s) {
        // Call the recursive DFS from index 0 with an empty set.
        return dfs(0, std::unordered_set<std::string>(), s);
    }

private:
    int dfs(int i, std::unordered_set<std::string> curSet, const std::string& s) {
        if (i == s.length()) {
            return 0;  // If we've reached the end of the string, return 0 (no more substrings to add).
        }

        int res = 0;
        // Try all possible substrings starting from index i
        for (int j = i; j < s.length(); ++j) {
            std::string subStr = s.substr(i, j - i + 1);  // Extract the substring from index i to j
            if (curSet.find(subStr) != curSet.end()) {
                continue;  // If the substring is already in the set, skip it
            }

            curSet.insert(subStr);  // Add the current substring to the set
            // Recursively calculate the result for the next index (j+1)
            res = std::max(res, 1 + dfs(j + 1, curSet, s));
            curSet.erase(subStr);  // Backtrack: remove the substring from the set
        }

        return res;  // Return the maximum result for the current state
    }
};
