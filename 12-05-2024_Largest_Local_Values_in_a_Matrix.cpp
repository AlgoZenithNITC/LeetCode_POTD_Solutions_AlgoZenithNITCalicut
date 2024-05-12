class Solution {
public:
    vector<vector<int>> largestLocal(vector<vector<int>>& grid) {
        int n= grid.size();
        vector<vector<int>>maxLocal(n-2,vector<int>(n-2,0));
        int largest_Value=0;
        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                  for(int k=i;k<=i+2;k++){
                    for(int z=j;z<=j+2;z++){
                        largest_Value= max(largest_Value,grid[k][z]);
                    }
                  }
            maxLocal[i][j]=largest_Value;
            largest_Value=0;
            }
        }
        return maxLocal;
    }
};
