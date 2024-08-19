class Solution {
public:

    int solve(int n, int s , int c){
        if(s==n) return 0;
        if(s>n) return 1e9;

        int paste = 1 + solve(n,s+c,c);

        int copy = 1e9 ;
        if(c<s) copy = 1 + solve(n,s,s);

        return min(paste,copy);
    }

    int minSteps(int n) {
       if(n==1) return 0;
       return 1+solve(n,1,1);
    }
};
