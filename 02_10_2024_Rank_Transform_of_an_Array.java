import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mpp = new HashMap<>();
        
        for (int i : arr) {
            mpp.put(i, mpp.getOrDefault(i, 0) + 1);
        }
        
        int m = 1;
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            mpp.put(it.getKey(), m++);
        }
        
        for (int i : arr) {
            ans.add(mpp.get(i));
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
}

