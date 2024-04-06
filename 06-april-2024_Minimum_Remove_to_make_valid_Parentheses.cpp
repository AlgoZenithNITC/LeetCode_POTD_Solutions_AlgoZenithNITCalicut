class Solution {
public:
    string minRemoveToMakeValid(string s) {
        stack<pair<char,int>> st;

        int n = s.length();

        for(int i=0;i<n;i++){
           if(s[i]=='('){
            st.push({'(',i}); 
           }
           if(s[i]==')'){
            if(st.empty()==true){
                s[i]='#';
            }else{
                st.pop();
            }
           }
        }

        while(st.empty()==false){
            s[st.top().second]='#';
            st.pop();
        }

        for(int i=0;i<n;i++){
          if(s[i]=='#')
          {
            s.erase(i,1);
            i--;
          }
        }

        return s;
    }
};
