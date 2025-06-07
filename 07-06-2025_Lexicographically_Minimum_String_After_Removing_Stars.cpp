class Solution {
public:
    string clearStars(string s) {
        

        int n = s.size();
        priority_queue<char, vector<char>, greater<char>> pq;

        unordered_map<char,vector<int>> indexmap;

        vector<bool> v (n,true);
     
        for(int i=0;i<n;i++)
        {
             if(s[i]!='*')
             {
                 pq.push(s[i]);
                 indexmap[s[i]].push_back(i);
              
            }

            else
            {
                 char currentmin = pq.top();
                 pq.pop();

                 int lastpos = indexmap[currentmin].back();
            
                 indexmap[currentmin].pop_back();

                 //dont include the star
                 v[i] = false;
                 //dont include char at the occurence we had to remove

                 v[lastpos] = false;
            }
        }


        string result = "";

        for(int i=0;i<n;i++)
        {
             if(v[i])
             result += s[i];
        }


        return result;

        
    }
};
