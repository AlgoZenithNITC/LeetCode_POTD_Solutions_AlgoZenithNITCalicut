class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        int left=0,now=0,nr=INT_MAX;
        for(int right=0;right<blocks.size();right++){
            if(blocks[right]=='W')
            now++;
            if(right-left+1==k){
                nr=min(nr,now);
                if(blocks[left]=='W')
                now--;
                left++;
            }
        }
        return nr;
    }
};