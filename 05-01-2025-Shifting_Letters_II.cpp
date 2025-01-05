class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) 

    {
        int n = s.size();

        vector <int> diffarray(n,0);

        for(auto query : shifts)
        {
            int left = query[0];

            int right = query[1];
            int dir = 1;
            if(query[2]==0)
            {
                dir = -1;
            }

            diffarray[left]+=dir;

            if(right+1<n)
            {
                diffarray[right+1] -=dir;
            }
        } 

        int prefixsum = 0;

         for(int i=0;i<n;i++)
         {  
            int pos = s[i]-'a';

            prefixsum+=diffarray[i];

            int newpos = (pos+prefixsum)%26;

            if(newpos<0)
            {
                newpos+=26;
            }
            
            s[i] = 'a'+newpos;


            
         }

         return s;
    }
};
