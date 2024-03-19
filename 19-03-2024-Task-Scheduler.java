import java.util.*;

class Solution {
    public int leastInterval(List<Character> tasks, int n) {
        int size = tasks.size();
        Map<Character, Integer> mp = new HashMap<>();
        for (char it : tasks) {
            mp.put(it, mp.getOrDefault(it, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int it : mp.values()) {
            maxHeap.offer(it);
        }
        
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;
            if (maxHeap.size() > 0) {
                int curr = maxHeap.poll();
                int count = curr - 1;
                if (count > 0) {
                    q.offer(new Pair<>(count, time + n));
                }
            }
            if (!q.isEmpty() && q.peek().getValue() == time) {
                maxHeap.offer(q.peek().getKey());
                q.poll();
            }
        }
        return time;
    }
}

