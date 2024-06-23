class Solution {
    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> increase = new LinkedList<>();
        LinkedList<Integer> decrease = new LinkedList<>();

        int max = 0,left = 0;
        for(int right = 0; right < nums.length; right++){
            int n = nums[right];

            while(increase.size() > 0 && n < increase.getLast()){
                increase.removeLast();
            }
            increase.add(n);
            while(decrease.size() > 0 && n > decrease.getLast()){
                decrease.removeLast();
            }
            decrease.add(n);

            while(decrease.getFirst() - increase.getFirst() > limit){
                if(nums[left] == decrease.getFirst()){
                    decrease.removeFirst();
                }
                if(nums[left] == increase.getFirst()){
                    increase.removeFirst();
                }
                left++;
            }
            int size = right - left + 1;
            max = Math.max(max, size);
        }
        return  max;
    }
}
