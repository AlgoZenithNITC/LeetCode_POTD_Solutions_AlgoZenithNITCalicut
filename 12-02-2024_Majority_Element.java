import java.util.List;

public class Solution {
    public int majorityElement(List<Integer> nums) {
        
        int ele = nums.get(0);
        int count = 1;
        int n = nums.size();
        for (int i = 1; i < n; i++) {
            if (count == 0) {
                ele = nums.get(i);
                count++;
            } else if (ele == nums.get(i)) {
                count++;
            } else {
                count--;
            }
        }
        return ele;
    }
}


