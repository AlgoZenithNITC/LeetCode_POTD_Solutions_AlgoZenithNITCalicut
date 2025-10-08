class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {

        int n = spells.size();

        sort(potions.begin(),potions.end());
        
        vector<int> res(n,0);
    
        for(int i=0;i<n;i++)
        {
            int left = 0;
            int right = potions.size()-1;

            int m = potions.size();
            int ans = m;
            
            while(left<=right)
            {   
                
                int mid = left + (right-left)/2;

                long long product = static_cast<long long>(spells[i]) *potions[mid]  ;

                if(product>=success)
                {
                    ans = mid;
                    right = mid -1;
                }

                else
                {
                    left = mid+1;
                }
            }


            res[i] = m - ans;
        }


        return res;
        
    }
};
