import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pq.offer(num);
        }

        long score = 0;

        while (k > 0) {
            int ele = pq.poll();
            score += ele;
            pq.offer((int) Math.ceil(ele / 3.0));
            k--;
        }

        return score;
    }
}

