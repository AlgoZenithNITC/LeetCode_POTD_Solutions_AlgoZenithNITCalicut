class Solution {
public:
    int candy(vector<int>& ratings)
    {
        int n=ratings.size();
        if(n==1)
            return 1;

        int candy=n;

        int i=1;
        while(i<n)
        {
            while(i<n && ratings[i]==ratings[i-1])
            {
                i++;
                continue;
            }
            int peak=0;
            while(i<n && ratings[i-1]<ratings[i] && i<n)
            {
                peak++;
                candy+=peak;
                i++;
            }

            int depth=0;
            while(i<n && ratings[i-1]>ratings[i] )
            {
                depth++;
                candy+=depth;
                i++;
            }

            candy-=min(depth,peak);
            
        }
        return candy;
    }
};