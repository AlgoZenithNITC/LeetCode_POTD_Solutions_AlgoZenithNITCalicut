class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
       int n = s.size();
       vector<int> temp(n);

       for(int i=0;i<n;i++){
        temp[i]=abs(s[i]-t[i]);
       }
       int l=0 ,j=0, l_cost = 0;
       int ans =0;
       for(int i=0;i<n;i++){
          l++;
          l_cost+=temp[i];
          if(l_cost>maxCost){
            ans=max(ans,l-1);
            while(l_cost>maxCost and j<=i){
                l--;
                l_cost-=temp[j];
                j++;
            }
          }
       }

       ans = max(ans,l);

       return ans ;
    }
};
