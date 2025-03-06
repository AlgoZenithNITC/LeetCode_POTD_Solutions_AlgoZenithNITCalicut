class Solution {
public:
    vector<int> findMissingAndRepeatedValues(vector<vector<int>>& grid) 
    {
        int n  =  grid.size();

        int size = n*n + 1;

        vector<int> res;

        vector<int> map(size,0);


        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            { 
                 int value = grid[i][j];
                 map[value]+=1;
            }
        }        

        int num1=-1;
        int num2=-1;

        for(int i=1;i<size;i++)
        {
            if(map[i]==2)
            {
                 num1=i;
            } 

            else if(map[i]==0)
            {
                 num2=i;
            }
        }

        res.push_back(num1);
        res.push_back(num2);

        return res;
    }
};
