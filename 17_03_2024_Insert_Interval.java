import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> insert(List<List<Integer>> intervals, List<Integer> newInterval) {
        List<List<Integer>> ans = new ArrayList<>();
        int x = newInterval.get(0);
        int y = newInterval.get(1);
        int i = 0;
        int n = intervals.size();
        while (i < n) {
            if (intervals.get(i).get(1) < x) {
                ans.add(intervals.get(i));
            } else if (intervals.get(i).get(0) > y) {
                break;
            } else {
                x = Math.min(intervals.get(i).get(0), x);
                y = Math.max(intervals.get(i).get(1), y);
            }
            i++;
        }
        ans.add(List.of(x, y));
        while (i < n) {
            ans.add(intervals.get(i));
            i++;
        }
        return ans;
    }
}

