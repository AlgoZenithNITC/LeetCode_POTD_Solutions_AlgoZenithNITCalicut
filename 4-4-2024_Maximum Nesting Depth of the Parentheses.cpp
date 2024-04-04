class Solution {
public:
    int maxDepth(string s) {
        int max=0;
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s[i]=='('){
                c++;
            }
            else if (s[i]==')'){
               if(max<c){ 
                max=c;
               }
                c--; 
            }
        }
    return max;
    }
};