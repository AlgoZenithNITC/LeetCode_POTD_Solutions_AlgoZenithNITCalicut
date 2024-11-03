class Solution {
public:
    bool rotateString(string s, string goal) {
        if(s.length() != goal.length())
            return false;

        s = s+s;
        int i = 0, j = 0;
        int n = goal.length();

        while(i < 2*n && j < n){
            if(s[i] == goal[j]){
                i++;
                j++;
            }
            else{
                i = i-j+1;
                j = 0;
            }
            if(j == n)
                return true;
        }

        return false;
    }
};
