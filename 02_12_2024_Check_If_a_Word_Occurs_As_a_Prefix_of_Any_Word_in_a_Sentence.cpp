class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        stringstream s(sentence);
        string word;
        int n = searchWord.size();
        int t = 0;
        while(s>>word)
        {
            t++;
            if(searchWord == word.substr(0,n))
            {
                return t;
            }
        }
        return -1;
    }
};
