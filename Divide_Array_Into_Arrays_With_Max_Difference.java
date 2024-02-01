class Solution {
   public int[][] divideArray(int[] nums, int k) {
       int[][] ans=new int[nums.length/3][3];
       Arrays.sort(nums);
       int i,j=0,l=0;
        for(i=0;i<nums.length;i=i+3)
        {
            if(nums[i+2]-nums[i]>k)
            {
                return new int [0][0];
            }
            else
            {
                l=i;
                for(int m=0;m<3;m++)
                {
                    ans[j][m]=nums[l];
                    l=l+1;
                }
                j++;
            }
        }
        return ans;
   }
}
