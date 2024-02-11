class Solution {
public:

   int n, m;
   int t[71][71][71];

   int solve(vector<vector<int>> &grid , int r , int c1 , int c2){
       if(r>=m){
           return 0;
       }

       if(t[r][c1][c2]!=-1) 
       return t[r][c1][c2];

       int sum = grid[r][c1];
       if(c1!=c2) 
       sum+=grid[r][c2];

       int ans =0;

       for(int i=-1;i<=1;i++){
           for(int j=-1;j<=1;j++){
    
               int newc1=c1+i;
               int newc2=c2+j;

               if(newc2>=0 && newc2<n && newc1>=0 && newc1<n)
                ans =max(ans,solve(grid,r+1,newc1,newc2));
           }
       }

       return t[r][c1][c2]=sum+ans;
   }
   
    int cherryPickup(vector<vector<int>>& grid) {
         m = grid.size();
         n = grid[0].size();
        memset(t,-1,sizeof(t));

        return solve(grid,0,0,n-1);
    }
};
