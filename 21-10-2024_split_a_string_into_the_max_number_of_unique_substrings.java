class Solution {
    public int maxUniqueSplit(String s) {
        // We need to start dfs from index 0 with an empty set and memoization map
        return dfs(0, new HashSet<String>(), s, new HashMap<>());
    }

    private int dfs(int i, Set<String> curSet, String s, Map<String, Integer> memo) {
        if (i == s.length()) {
            return 0;  // If we've reached the end of the string, no more splits are possible.
        }
        
        // Memoization: generate a unique key for the current state
        String key = i + ":" + curSet.toString();  // Key to memoize based on current index and set
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = 0;  // Result to store the maximum number of unique substrings

        // Explore all substrings starting from index i
        for (int j = i; j < s.length(); j++) {
            String subStr = s.substring(i, j + 1);  // Substring from index i to j
            if (curSet.contains(subStr)) {
                continue;  // Skip if the substring has already been used
            }
            // Add the current substring to the set and recurse for the remaining string
            curSet.add(subStr);
            res = Math.max(res, 1 + dfs(j + 1, curSet, s, memo));  // Recursively calculate the result
            curSet.remove(subStr);  // Backtrack: remove the substring from the set
        }

        // Memoize the result for the current state
        memo.put(key, res);
        return res;
    }
}
