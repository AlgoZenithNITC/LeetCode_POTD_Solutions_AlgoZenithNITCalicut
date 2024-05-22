class Solution {
public:
    
    int n ;

    bool is_palin(int a,int b,string &s){
        int i = a , j=b;
        while(i<=j){
            if(s[i]!=s[j]) return false;
            i++;
            j--;
        }

        return true;
    }

    void solve(int a , string &s , vector<vector<string>> &ans , vector<string> &temp){
        
        if(a==n){
            ans.push_back(temp);
            return;
        }

        for(int i=a;i<n;i++){
            temp.push_back(s.substr(a,i-a+1));
            if(is_palin(a,i,s))
            solve(i+1,s,ans,temp);
            temp.pop_back();
        }
    }

    vector<vector<string>> partition(string s) {
        n = s.size();
        vector<vector<string>> ans ;
        vector<string> temp;
        solve(0,s,ans,temp);

        return ans;
    }
};
