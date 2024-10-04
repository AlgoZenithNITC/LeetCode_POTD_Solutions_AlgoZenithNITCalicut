import java.util.HashMap;

public class Solution {
    public long dividePlayers(int[] skill) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        
        for (int i : skill) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
            mini = Math.min(mini, i);
            maxi = Math.max(maxi, i);
        }
        
        long ans = 0;
        int sum = mini + maxi, n = skill.length;
        
        for (int i : mp.keySet()) {
            if (mp.get(i) == 0) continue;
            
            int rem = sum - i;
            if (!mp.containsKey(rem) || !mp.get(rem).equals(mp.get(i))) return -1;
            else {
                if (rem == i) mp.put(i, mp.get(i) / 2);
                ans += (long) mp.get(i) * rem * i;
                mp.put(rem, 0);
            }
        }
        return ans;
    }
}
