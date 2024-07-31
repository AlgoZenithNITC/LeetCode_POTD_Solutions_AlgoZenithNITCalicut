class Solution {
public:
    
    int n , n_width; 

    int solve(int i , vector<vector<int>> &books , int width , int height,vector<vector<int>> &memo){
        int maxHeight = max(height , books[i][1]);

        if(i==n-1){
            if(books[i][0]<=width) return maxHeight ;
            return height + books[i][1];
        }

        if(memo[i][width]!=-1) return memo[i][width];

        int f_shelf = INT_MAX;
        if(books[i][0]<=width){
            f_shelf = solve(i+1,books,width-books[i][0],maxHeight,memo);
        }

        int s_shelf = height + solve(i+1,books,n_width-books[i][0],books[i][1],memo);

        return memo[i][width]=min(f_shelf,s_shelf);
    }

    int minHeightShelves(vector<vector<int>>& books, int shelfWidth) {
       n = books.size();
       n_width = shelfWidth;

       vector<vector<int>> memo(n,vector<int>(shelfWidth+1,-1));

       return solve(0,books,shelfWidth,0,memo); 
    }
};
