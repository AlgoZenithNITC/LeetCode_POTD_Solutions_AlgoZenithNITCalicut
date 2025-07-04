class Solution {
public:
    char kthCharacter(long long k, vector<int>& operations) {
        long long a =1;
        int n=0;
        while(k>a){
            a = a*2;
            n++;
        }
        int m =0;
        while(n>0 && k>1){
            if(a/2 <k){
                a/=2;
                k-=a;
                if(operations[n-1]==1) m++;
            }
            else{
                a/=2;
            }
            n--;
        }
        return 'a'+(m%26);
    }
};
