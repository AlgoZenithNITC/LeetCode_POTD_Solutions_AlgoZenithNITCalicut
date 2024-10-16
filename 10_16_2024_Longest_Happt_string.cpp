class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        priority_queue<pair<int,string>> pq;
        if(a>0) pq.push({a,"a"});
        if(b>0) pq.push({b,"b"});
        if(c>0) pq.push({c,"c"});

        string s = "";

        while(pq.empty()==false){
            pair<int,string> temp = pq.top();
            pq.pop();
            int cnt = temp.first;
            string node = temp.second;

            int n = s.size();
                if(n>=2 && s[n-1]==node[0] && s[n-2]==node[0]){
                    if(pq.empty()) break;
                     pair<int,string> temp1 = pq.top();
                     pq.pop();
                     s+=temp1.second;
                     if(temp1.first-1>0)
                      pq.push({temp1.first-1,temp1.second});
                }else{
                    s+=node;
                    cnt--;
                }

            if(cnt>0) pq.push({cnt,node});
        }

        return s;
    }
};
