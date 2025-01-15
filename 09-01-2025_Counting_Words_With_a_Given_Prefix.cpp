#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        int count = 0;
        int len = pref.length();
        for (const string& word : words) {
            if (len <= word.length()) {
                string sub = word.substr(0, len);
                if (pref == sub) {
                    count++;
                }
            }
        }
        return count;
    }
};