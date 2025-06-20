class Solution {
public:
    int maxDistance(string s, int k) {
        int ans=0,n=0,so=0,e=0,w=0;
        for(int i=0;i<s.size();i++){
            char c=s[i];
            if(c=='N')n++;
            else if(c=='S')so++;
            else if(c=='W')w++;
            else if(c=='E')e++;
            int m=abs(n-so)+abs(e-w);
            int dis= m+ min(2*k,i+1-m);
            ans=max(ans,dis);
        }
        return ans;
    }
};