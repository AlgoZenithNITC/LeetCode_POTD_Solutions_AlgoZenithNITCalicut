import java.util.HashMap;

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : order.toCharArray()) {
            count.put(c, 0);
        }
        for (char c : s.toCharArray()) {
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : order.toCharArray()) {
            ans.append(String.valueOf(c).repeat(count.get(c)));
        }
        for (char c : s.toCharArray()) {
            if (!count.containsKey(c)) {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}

