import java.util.*;

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        for(char ch: s.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        list.addAll(mp.entrySet());
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));
        for(Map.Entry<Character, Integer> entry: list){
            for(int i = 0; i < entry.getValue(); i++) {
                ans.append(entry.getKey());
            }
        }
        return ans.toString();
    }
}

