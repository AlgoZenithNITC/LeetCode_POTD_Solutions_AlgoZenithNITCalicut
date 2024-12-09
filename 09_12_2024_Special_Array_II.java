import java.util.*;

class VectorHash {
    public int hash(List<Integer> v) {
        int hash = 0;
        for (int i : v) {
            hash ^= Integer.hashCode(i) + 0x9e3779b9 + (hash << 6) + (hash >> 2);
        }
        return hash;
    }
}

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        List<int[]> check = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] % 2 == nums[i] % 2) {
                check.add(new int[]{i - 1, i});
            }
            if (i + 1 != n && nums[i + 1] % 2 == nums[i] % 2) {
                check.add(new int[]{i, i + 1});
            }
        }
        Map<List<Integer>, Boolean> mpp = new HashMap<>();
        List<List<Integer>> c = new ArrayList<>();
        for (int[] query : queries) {
            c.add(Arrays.asList(query[0], query[1]));
        }
        Collections.sort(c, Comparator.comparingInt(a -> a.get(0)));
        int m = check.size(), k = queries.length;
        boolean[] ans = new boolean[k];
        for (int i = 0, j = 0; i < k; i++) {
            while (j < m && check.get(j)[0] < c.get(i).get(0)) {
                j++;
            }
            if (j < m && check.get(j)[0] >= c.get(i).get(0) && check.get(j)[1] <= c.get(i).get(1)) {
                mpp.put(c.get(i), false);
            } else {
                mpp.put(c.get(i), true);
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = mpp.get(Arrays.asList(queries[i][0], queries[i][1]));
        }
        return ans;
    }
}

