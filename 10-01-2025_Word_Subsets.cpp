class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        vector<string> res;
        map<char,int> max_freq;
        for(string str : words2){
            map<char,int> a;
            for(char i : str){
                a[i]++;
            }
            for(auto i : a){
                if(max_freq[i.first] < i.second){
                    max_freq[i.first] = i.second;
                }
            }
        }
        for(string str : words1){
            map<char,int> a;
            for(char i : str){
                a[i]++;
            }
            res.push_back(str);
            for(auto i : max_freq){
                if(a[i.first] < i.second){
                    res.pop_back();
                    break;
                }
            }
        }
        return res;
    }
};
