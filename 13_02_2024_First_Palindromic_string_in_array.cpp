#include <string>
#include <vector>

class Solution {
public:
    std::string firstPalindrome(std::vector<std::string>& words) {
        
        for (const auto& word : words) {
            if (std::string(word.rbegin(), word.rend()) == word) {
                return word;
            }
        }
        return "";
    }
};
