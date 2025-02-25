class Solution {
    public int numOfSubarrays(int[] arr) {
       long oddcount = 0, prefixsum = 0;
        int arrSize = arr.length;
        
        for (int num : arr) {
            prefixsum += num;
            oddcount += prefixsum % 2;
        }
        
        oddcount = oddcount + (arrSize - oddcount) * oddcount;
        return (int)(oddcount % 1000000007); 
    }
}
