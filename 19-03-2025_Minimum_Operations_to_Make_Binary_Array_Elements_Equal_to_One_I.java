public class Solution 
{
    private void flip(int i, int[] nums) 
    {
        for (int j = i; j < i + 3; j++) 
        {
            nums[j] ^= 1; 
        }
    }
    
    public int minOperations(int[] nums) 
    {
        int zeroCount = 0;
        for (int num : nums) 
        {
            if (num == 0) zeroCount++;
        }
        if (zeroCount == 0) return 0;
        
        int flips = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) 
        {
            if (nums[i] == 0) 
            {
                flip(i, nums);
                flips++;
            }
        }
        

        zeroCount = 0;
        for (int num : nums) 
        {
            if (num == 0) zeroCount++;
        }
        return zeroCount == 0 ? flips : -1;
    }
}
