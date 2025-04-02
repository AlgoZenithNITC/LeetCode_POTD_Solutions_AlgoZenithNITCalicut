public class Main {
    public static long maximumTripletValue(int[] nums) {
        long maxVal = Long.MIN_VALUE;
        int numsSize = nums.length;

        for(int i = 0; i < numsSize - 2; ++i) {
            for(int j = i + 1; j < numsSize - 1; ++j) {
                for(int k = j + 1; k < numsSize; ++k) {
                    long tmp = (long)(nums[i] - nums[j]) * nums[k];
                    if(tmp > maxVal) {
                        maxVal = tmp;
                    }
                }
            }
        }

        return maxVal < 0 ? 0 : maxVal;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(maximumTripletValue(nums));
    }
}
