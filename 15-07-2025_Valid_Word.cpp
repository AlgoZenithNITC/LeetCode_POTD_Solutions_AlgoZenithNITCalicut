#include <string>
#include <cctype>
using namespace std;

class Solution {
public:
    bool isValid(string word) {
        if (word.length() < 3) return false;

        for (char c : word) {
            if (!isalnum(c)) return false;
        }

        string lower;
        for (char c : word) {
            lower += tolower(c);
        }

        bool hasVowel = false, hasConsonant = false;

        for (char c : lower) {
            if (string("aeiou").find(c) != string::npos) {
                hasVowel = true;
            } else if (string("bcdfghjklmnpqrstvwxyz").find(c) != string::npos) {
                hasConsonant = true;
            }
        }

        return hasVowel && hasConsonant;
    }
};
