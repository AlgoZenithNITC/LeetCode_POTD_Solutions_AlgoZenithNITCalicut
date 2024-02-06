import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> temp = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if (!temp.containsKey(sorted)) {
                temp.put(sorted, new ArrayList<>());
            }
            temp.get(sorted).add(s);
        }
        for (List<String> group : temp.values()) {
            ans.add(group);
        }
        return ans;
    }
}

