class Solution {
public:
    string compressedString(string word) {
        int n=word.size();
        string ans="";
        int i=1;
        int st=0;
        while(i<n){
            while(i<n && word[i-1]==word[i] && (i-st)<10){
                i++;
            }
            if(i-st==10){i--;}
            ans.append(to_string(i-st));
            ans.push_back(word[st]);
            st=i;
            i++;
        }
        if(st==n-1){
            ans.append(to_string(i-st));
            ans.push_back(word[st]);
        }
        return ans;
    }
};