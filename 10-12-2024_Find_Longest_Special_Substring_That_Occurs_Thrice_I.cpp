class Solution {
public:
    int maximumLength(std::string s) {
        std::unordered_map<std::string, int> map;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            std::string curString = "";
            for (int j = i; j < n; j++) {
                // Check if the substring can continue to be "special"
                if (curString.empty() || s[j] == curString.back()) {
                    curString += s[j];  // Append the current character
                    map[curString]++;
                } else {
                    break;  // Break if the character is different
                }
            }
        }

        int maxLen = -1;
        for (const auto& entry : map) {
            const std::string& str = entry.first;
            int freq = entry.second;
            if (freq > 2) {
                maxLen = std::max(maxLen, (int)str.length());
            }
        }

        return maxLen;
    }
};
